package dev.ghlima.locatech.aggregatorservice.dto;


import org.springframework.graphql.data.method.annotation.SchemaMapping;

@SchemaMapping("CreateReservationResponse")
public class CreateReservationResponseDTO {
  private Long reservationId;
  private String message;

  public CreateReservationResponseDTO(Long reservationId, String message) {
    this.reservationId = reservationId;
    this.message = message;
  }

  public Long getReservationId() {
    return reservationId;
  }

  public void setReservationId(Long reservationId) {
    this.reservationId = reservationId;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}