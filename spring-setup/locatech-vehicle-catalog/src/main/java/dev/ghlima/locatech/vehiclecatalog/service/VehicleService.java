package dev.ghlima.locatech.vehiclecatalog.service;


import dev.ghlima.locatech.catalog.AddVehicleRequest;
import dev.ghlima.locatech.catalog.AddVehicleResponse;
import dev.ghlima.locatech.catalog.CatalogServiceGrpc.CatalogServiceImplBase;
import dev.ghlima.locatech.catalog.ListAvailableVehiclesRequest;
import dev.ghlima.locatech.vehiclecatalog.service.handler.VehicleCatalogRequestHandler;
import dev.ghlima.locatech.catalog.ListAvailableVehiclesResponse;
import dev.ghlima.locatech.catalog.GetVehicleByIdResponse;
import dev.ghlima.locatech.catalog.GetVehicleByIdRequest;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class VehicleService extends CatalogServiceImplBase {
  
  private final VehicleCatalogRequestHandler requestHandler;

  public VehicleService(VehicleCatalogRequestHandler requestHandler) {
    this.requestHandler = requestHandler;
  }

  @Override
  public void addVehicle(AddVehicleRequest request, StreamObserver<AddVehicleResponse> responseObserver) {
    var response = requestHandler.saveVehicle(request);
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void listAvailableVehicles(ListAvailableVehiclesRequest request, StreamObserver<ListAvailableVehiclesResponse> responseObserver) {
    var response = requestHandler.getAllAvailableVehicles();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void getVehicleById(GetVehicleByIdRequest request, StreamObserver<GetVehicleByIdResponse> responseObserver) {
    var response = requestHandler.getVehicleById(request);
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
