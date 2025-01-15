package dev.ghlima.locatech.vehiclecatalog.service.exception;

import dev.ghlima.locatech.vehiclecatalog.exception.VehicleNotFoundException;
import io.grpc.Status;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

@GrpcAdvice
public class ServiceExceptionHandler {
  
  @GrpcExceptionHandler(VehicleNotFoundException.class)
  public Status handleVehicleNotFound(VehicleNotFoundException e) {
    return Status.INVALID_ARGUMENT.withDescription(e.getMessage());
  }
}
