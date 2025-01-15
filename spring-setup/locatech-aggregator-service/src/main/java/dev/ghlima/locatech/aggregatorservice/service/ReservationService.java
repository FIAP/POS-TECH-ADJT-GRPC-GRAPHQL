package dev.ghlima.locatech.aggregatorservice.service;

import dev.ghlima.locatech.aggregatorservice.dto.CompleteReservationResponseDTO;
import dev.ghlima.locatech.aggregatorservice.dto.CreateReservationResponseDTO;
import dev.ghlima.locatech.aggregatorservice.dto.ReservationDTO;
import dev.ghlima.locatech.reservation.GetReservationRequest;
import dev.ghlima.locatech.reservation.CreateReservationRequest;
import dev.ghlima.locatech.reservation.CompleteReservationRequest;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import dev.ghlima.locatech.reservation.ReservationServiceGrpc.ReservationServiceBlockingStub;

@Service
public class ReservationService {
  
  @GrpcClient("reservation")
  private ReservationServiceBlockingStub reservationServiceBlockingStub;
  
  public ReservationDTO getReservationById(Long reservationId) {
    var request = GetReservationRequest.newBuilder()
      .setReservationId(reservationId).build();
    var response = reservationServiceBlockingStub.getReservation(request);
    
    return new ReservationDTO(response.getReservation());
  }
  
  public CreateReservationResponseDTO createReservation(ReservationDTO reservationDTO) {
    var request = CreateReservationRequest.newBuilder()
      .setVehicleId(reservationDTO.getVehicleId())
      .setUserId(reservationDTO.getUserId())
      .setStartDate(reservationDTO.getStartDate())
      .setEndDate(reservationDTO.getEndDate())
      .build();
    
    var response = reservationServiceBlockingStub.createReservation((request));
    
    return new CreateReservationResponseDTO(response.getReservationId(), response.getMessage());
  }
  
  public CompleteReservationResponseDTO completeReservation(Long reservationId) {
    var request = CompleteReservationRequest.newBuilder().setReservationId(reservationId).build();
    var response = reservationServiceBlockingStub.completeReservation(request);
    return new CompleteReservationResponseDTO(response.getMessage(), response.getTotalDays());
  }
}
