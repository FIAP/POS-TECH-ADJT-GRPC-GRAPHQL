package dev.ghlima.locatech.aggregatorservice.dto;


import org.springframework.graphql.data.method.annotation.SchemaMapping;

@SchemaMapping("AddVehicleResponse")
public class AddVehicleResponseDTO {
  private Long vehicleId;
  private String message;

  public AddVehicleResponseDTO(Long vehicleId, String message) {
    this.vehicleId = vehicleId;
    this.message = message;
  }

  public Long getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(Long vehicleId) {
    this.vehicleId = vehicleId;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
