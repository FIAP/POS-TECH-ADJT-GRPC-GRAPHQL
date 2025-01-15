package exception;

public class ReservationNotFoundException extends RuntimeException{
  
  private static final String MESSAGE = "Reservation [id=%d] is not found";
  
  public ReservationNotFoundException(Long reservationId) {
    super(MESSAGE.formatted(reservationId));
  }
}
