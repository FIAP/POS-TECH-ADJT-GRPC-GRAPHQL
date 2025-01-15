package dev.ghlima.locatech.aggregatorservice.dto;

import dev.ghlima.locatech.catalog.VehicleProto;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

import java.util.List;
import java.util.stream.Collectors;

@SchemaMapping("Vehicle")
public class VehicleDTO {

  private Long id;
  private String make;
  private String model;
  private String category;
  private boolean isAvailable;

  public VehicleDTO(VehicleProto vehicleProto) {
    this.id = vehicleProto.getId();
    this.make = vehicleProto.getMake();
    this.model = vehicleProto.getModel();
    this.category = vehicleProto.getCategory();
    this.isAvailable = vehicleProto.getIsAvailable();
  }

  public VehicleDTO() {}

  public static List<VehicleDTO> fromProtoList(List<VehicleProto> vehicleProtos) {
    return vehicleProtos.stream().map(VehicleDTO::new).collect(Collectors.toList());
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public boolean getIsAvailable() {
    return isAvailable;
  }

  public void setIsAvailable(boolean available) {
    isAvailable = available;
  }
}