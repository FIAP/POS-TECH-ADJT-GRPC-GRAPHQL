package dev.ghlima.locatech.vehiclecatalog.utils;

import dev.ghlima.locatech.vehiclecatalog.entity.Vehicle;
import dev.ghlima.locatech.catalog.AddVehicleRequest;
import dev.ghlima.locatech.catalog.GetVehicleByIdResponse;
import dev.ghlima.locatech.catalog.VehicleProto;
import dev.ghlima.locatech.catalog.ListAvailableVehiclesResponse;
import dev.ghlima.locatech.catalog.AddVehicleResponse;

import java.util.List;
import java.util.stream.Collectors;

public class EntityMessageMapper {
  
  public static Vehicle toEntity(AddVehicleRequest vehicle) {
    return new Vehicle(
      vehicle.getVehicle().getMake(),
      vehicle.getVehicle().getModel(),
      vehicle.getVehicle().getCategory(),
      vehicle.getVehicle().getIsAvailable()
    );
  }
  
  public static GetVehicleByIdResponse toVehicleProtoMessage(Vehicle vehicle) {
    return GetVehicleByIdResponse.newBuilder().setVehicle(
      VehicleProto.newBuilder()
        .setId(vehicle.getId())
        .setMake(vehicle.getMake())
        .setModel(vehicle.getModel())
        .setCategory(vehicle.getCategory())
        .setIsAvailable(vehicle.getAvailable())
        .build()
    ).build();
  }
  
  public static ListAvailableVehiclesResponse toListAvailableVehicleResponseMessage(
    List<Vehicle> vehicles
  ) {
    var vehiclesProto = vehicles.stream().map(
      vehicle -> VehicleProto.newBuilder()
        .setId(vehicle.getId())
        .setMake(vehicle.getMake())
        .setModel(vehicle.getModel())
        .setCategory(vehicle.getCategory())
        .setIsAvailable(vehicle.getAvailable())
        .build()
    ).collect(Collectors.toList());
    
    return ListAvailableVehiclesResponse
      .newBuilder().addAllVehicles(vehiclesProto).build();
    
  }
  
  public static AddVehicleResponse toAddVehicleResponseMessage(Vehicle vehicle) {
    return AddVehicleResponse.newBuilder()
      .setVehicleId(vehicle.getId())
      .setMessage("Vehicle added successfully")
      .build();
  }
  
  
}
