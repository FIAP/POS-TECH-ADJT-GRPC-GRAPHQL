package dev.ghlima.locatech.vehiclecatalog.service.handler;

import dev.ghlima.locatech.vehiclecatalog.exception.VehicleNotFoundException;
import dev.ghlima.locatech.vehiclecatalog.repository.VehicleRepository;
import dev.ghlima.locatech.catalog.GetVehicleByIdResponse;
import dev.ghlima.locatech.catalog.GetVehicleByIdRequest;
import dev.ghlima.locatech.vehiclecatalog.utils.EntityMessageMapper;
import dev.ghlima.locatech.catalog.ListAvailableVehiclesResponse;
import dev.ghlima.locatech.catalog.AddVehicleRequest;

import dev.ghlima.locatech.catalog.AddVehicleResponse;

import org.springframework.stereotype.Service;

@Service
public class VehicleCatalogRequestHandler {
  
  private final VehicleRepository repository;

  public VehicleCatalogRequestHandler(VehicleRepository repository) {
    this.repository = repository;
  }
  
  public GetVehicleByIdResponse getVehicleById(GetVehicleByIdRequest request) {
    var vehicle = repository
      .findById(request.getId())
      .orElseThrow(() -> new VehicleNotFoundException(request.getId()));
    
    return EntityMessageMapper.toVehicleProtoMessage(vehicle);
  }
  
  public ListAvailableVehiclesResponse getAllAvailableVehicles() {
    var vehicles = repository.findByAvailableTrue();
    return EntityMessageMapper.toListAvailableVehicleResponseMessage(vehicles);
  }
  
  public AddVehicleResponse saveVehicle(AddVehicleRequest request) {
    var vehicle = EntityMessageMapper.toEntity(request);
    var vehicleSave = repository.save(vehicle);
    return EntityMessageMapper.toAddVehicleResponseMessage(vehicleSave);
  }
}
