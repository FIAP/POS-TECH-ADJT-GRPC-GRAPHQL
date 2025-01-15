package dev.ghlima.locatech.aggregatorservice.dto;

import org.springframework.graphql.data.method.annotation.SchemaMapping;

@SchemaMapping("CompleteReservationResponse")
public class CompleteReservationResponseDTO {
  
  private String message;
  private Long TotalDays;

  public CompleteReservationResponseDTO(String message, Long totalDays) {
    this.message = message;
    TotalDays = totalDays;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Long getTotalDays() {
    return TotalDays;
  }

  public void setTotalDays(Long totalDays) {
    TotalDays = totalDays;
  }
}
