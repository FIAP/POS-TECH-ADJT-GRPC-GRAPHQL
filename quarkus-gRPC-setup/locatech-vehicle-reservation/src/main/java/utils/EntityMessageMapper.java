package utils;

import entity.Reservation;

import dev.ghlima.locatech.reservation.CreateReservationRequest;
import dev.ghlima.locatech.reservation.GetReservationResponse;
import dev.ghlima.locatech.reservation.ReservationProto;
import dev.ghlima.locatech.reservation.ReservationStatusProto;
import dev.ghlima.locatech.reservation.CompleteReservationResponse;
import dev.ghlima.locatech.reservation.GetReservationByVehicleIdResponse;


public class EntityMessageMapper {

  public static Reservation toEntiy(CreateReservationRequest request) {
    return new Reservation(
      request.getVehicleId(), 
      request.getUserId(), 
      request.getStartDate(), 
      request.getEndDate(), 
      ReservationStatus.PENDING);
  }

  public static GetReservationResponse toGetReservationResponseMessage(Reservation reservation) {
    return GetReservationResponse.newBuilder().setReservation(
      ReservationProto.newBuilder()
        .setReservationId(reservation.getReservationId())
        .setVehicleId(reservation.getVehicleId())
        .setUserId(reservation.getUserId())
        .setStartDate(reservation.getStartDate())
        .setEndDate(reservation.getEndDate())
        .setStatus(ReservationStatusProto.valueOf(reservation.getStatus().name()))
        .build()
    ).build();
  }

  public static CompleteReservationResponse toCompleteReservationResponseMessage(Long totalDays) {
    return CompleteReservationResponse
      .newBuilder()
      .setTotalDays(totalDays)
      .setMessage("Reservation completed successfully")
      .build();
  }

  public static GetReservationByVehicleIdResponse toGetReservationByVehicleIdResponseMessage(Reservation reservation) {
    return GetReservationByVehicleIdResponse.newBuilder()
      .setReservation(
        ReservationProto.newBuilder()
          .setReservationId(reservation.getReservationId())
          .setVehicleId(reservation.getVehicleId())
          .setUserId(reservation.getUserId())
          .setStartDate(reservation.getStartDate())
          .setEndDate(reservation.getEndDate())
          .setStatus(ReservationStatusProto.valueOf(reservation.getStatus().name()))
          .build()
      ).build();
  }

}
