package dev.ghlima.locatech.aggregatorservice.dto;

import dev.ghlima.locatech.reservation.ReservationProto;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

@SchemaMapping("Reservation")
public class ReservationDTO {

  private Long reservationId;
  private Long vehicleId;
  private Long userId;
  private String startDate;
  private String endDate;
  private String status;

  public ReservationDTO(ReservationProto reservationProto) {
    this.reservationId = reservationProto.getReservationId();
    this.vehicleId = reservationProto.getVehicleId();
    this.userId = reservationProto.getUserId();
    this.startDate = reservationProto.getStartDate();
    this.endDate = reservationProto.getEndDate();
    this.status = reservationProto.getStatus().name();
  }

  public ReservationDTO() {}


  public Long getReservationId() {
    return reservationId;
  }

  public void setReservationId(Long reservationId) {
    this.reservationId = reservationId;
  }

  public Long getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(Long vehicleId) {
    this.vehicleId = vehicleId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}