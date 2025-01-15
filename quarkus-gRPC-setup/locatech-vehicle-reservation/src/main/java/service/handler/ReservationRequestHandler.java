package service.handler;

import entity.Reservation;
import exception.ReservationNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import repository.ReservationRepository;

import dev.ghlima.locatech.reservation.CreateReservationResponse;
import dev.ghlima.locatech.reservation.CreateReservationRequest;
import dev.ghlima.locatech.reservation.GetReservationResponse;
import dev.ghlima.locatech.reservation.GetReservationRequest;
import dev.ghlima.locatech.reservation.GetReservationByVehicleIdResponse;
import dev.ghlima.locatech.reservation.CompleteReservationResponse;
import dev.ghlima.locatech.reservation.CompleteReservationRequest;


import utils.EntityMessageMapper;
import utils.ReservationStatus;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@ApplicationScoped
public class ReservationRequestHandler {

  private final ReservationRepository reservationRepository;

  public ReservationRequestHandler(ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  @Transactional
  public CreateReservationResponse createReservation(CreateReservationRequest request) {
    var reservation = EntityMessageMapper.toEntiy(request);
    reservationRepository.persistAndFlush(reservation);
    return CreateReservationResponse.newBuilder().setMessage("Reservation created successfully").setReservationId(reservation.getReservationId()).build();
  }

  @Transactional
  public GetReservationResponse getReservation(GetReservationRequest request) {
    Reservation reservation = reservationRepository
      .findByIdOptional(request.getReservationId())
      .orElseThrow(() -> new ReservationNotFoundException(request.getReservationId()));
    
    return EntityMessageMapper.toGetReservationResponseMessage(reservation);
  }

  @Transactional
  public GetReservationByVehicleIdResponse getReservationByVehicleId(dev.ghlima.locatech.reservation.GetReservationByVehicleIdRequest request) {
    Reservation reservation = reservationRepository
      .find("vehicleId", request.getVehicleId())
      .firstResultOptional()
      .orElseThrow(() -> new ReservationNotFoundException(request.getVehicleId()));
    
    return EntityMessageMapper.toGetReservationByVehicleIdResponseMessage(reservation);
  }

  @Transactional
  public CompleteReservationResponse completeReservation(CompleteReservationRequest request) {
    Reservation reservation = reservationRepository
      .findByIdOptional(request.getReservationId())
      .orElseThrow(() -> new ReservationNotFoundException(request.getReservationId()));

    reservation.setStatus(ReservationStatus.CONFIRMED);
    reservationRepository.persist(reservation);

    LocalDate startDate = LocalDate.parse(reservation.getStartDate());
    LocalDate endDate = LocalDate.parse(reservation.getEndDate());
    long totalDays = ChronoUnit.DAYS.between(startDate, endDate);

    return EntityMessageMapper.toCompleteReservationResponseMessage(totalDays);
  }
}
