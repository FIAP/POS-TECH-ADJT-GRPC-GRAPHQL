package repository;

import entity.Reservation;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class ReservationRepository  implements PanacheRepository<Reservation> {
    public Optional<Reservation> findByVehicleId(Long vehicleId) {
    return find("vehicleId", vehicleId).firstResultOptional();
  }
}
