package dev.ghlima.locatech.vehiclecatalog.exception;

public class VehicleNotFoundException extends RuntimeException{
  private static final String MESSAGE = "Vehicle [id=%d] is not found";
  
  public VehicleNotFoundException(Long vehicleId) {
    super(MESSAGE.formatted(vehicleId));
  }
}
