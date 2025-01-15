package dev.ghlima.locatech.aggregatorservice.dto;

import org.springframework.graphql.data.method.annotation.SchemaMapping;

@SchemaMapping("VehicleAndReservation")
public class VehicleAndReservationDTO {

  private VehicleDTO vehicle;
  private ReservationDTO reservation;

  public VehicleAndReservationDTO(VehicleDTO vehicle, ReservationDTO reservation) {
    this.vehicle = vehicle;
    this.reservation = reservation;
  }

  public VehicleDTO getVehicle() {
    return vehicle;
  }

  public void setVehicle(VehicleDTO vehicle) {
    this.vehicle = vehicle;
  }

  public ReservationDTO getReservation() {
    return reservation;
  }

  public void setReservation(ReservationDTO reservation) {
    this.reservation = reservation;
  }
}