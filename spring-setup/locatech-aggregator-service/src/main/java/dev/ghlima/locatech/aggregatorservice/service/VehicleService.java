package dev.ghlima.locatech.aggregatorservice.service;

import dev.ghlima.locatech.aggregatorservice.dto.AddVehicleResponseDTO;
import dev.ghlima.locatech.aggregatorservice.dto.ReservationDTO;
import dev.ghlima.locatech.aggregatorservice.dto.VehicleAndReservationDTO;
import dev.ghlima.locatech.aggregatorservice.dto.VehicleDTO;
import dev.ghlima.locatech.reservation.ReservationServiceGrpc.ReservationServiceBlockingStub;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import dev.ghlima.locatech.catalog.CatalogServiceGrpc.CatalogServiceBlockingStub;
import dev.ghlima.locatech.catalog.GetVehicleByIdRequest;
import dev.ghlima.locatech.catalog.ListAvailableVehiclesRequest;
import dev.ghlima.locatech.catalog.VehicleProto;
import dev.ghlima.locatech.catalog.AddVehicleRequest;
import dev.ghlima.locatech.reservation.GetReservationByVehicleIdRequest;

import java.util.List;

@Service
public class VehicleService {
  
  @GrpcClient("vehicle-catalog")
  private CatalogServiceBlockingStub catalogServiceBlockingStub;

  @GrpcClient("reservation")
  private ReservationServiceBlockingStub reservationServiceBlockingStub;
  
  public VehicleDTO getVehicleById(Long id) {
    var request = GetVehicleByIdRequest.newBuilder().setId(id).build();
    var response = catalogServiceBlockingStub.getVehicleById(request);
    return new VehicleDTO(response.getVehicle());
  }
  
  public List<VehicleDTO> listAvailableVehicles() {
    var request = ListAvailableVehiclesRequest.newBuilder().build();
    var response = catalogServiceBlockingStub.listAvailableVehicles(request);
    return VehicleDTO.fromProtoList(response.getVehiclesList());
  }

  public AddVehicleResponseDTO addVehicle(VehicleDTO vehicleDTO) {
    VehicleProto vehicleProto = VehicleProto.newBuilder()
      .setMake(vehicleDTO.getMake())
      .setModel(vehicleDTO.getModel())
      .setCategory(vehicleDTO.getCategory())
      .setIsAvailable(vehicleDTO.getIsAvailable())
      .build();
    var request = AddVehicleRequest.newBuilder().setVehicle(vehicleProto).build();
    var response = catalogServiceBlockingStub.addVehicle(request);
    return new AddVehicleResponseDTO(response.getVehicleId(), response.getMessage());

  }

  public VehicleAndReservationDTO getVehicleAndReservationById(Long vehicleId) {
    var vehicleRequest = GetVehicleByIdRequest.newBuilder().setId(vehicleId).build();
    var vehicleResponse = catalogServiceBlockingStub.getVehicleById(vehicleRequest);
    var vehicleDTO = new VehicleDTO(vehicleResponse.getVehicle());

    var reservationRequest = GetReservationByVehicleIdRequest.newBuilder().setVehicleId(vehicleId).build();
    var reservationResponse = reservationServiceBlockingStub.getReservationByVehicleId(reservationRequest);
    var reservationDTO = new ReservationDTO(reservationResponse.getReservation());

    return new VehicleAndReservationDTO(vehicleDTO, reservationDTO);
  }
}
