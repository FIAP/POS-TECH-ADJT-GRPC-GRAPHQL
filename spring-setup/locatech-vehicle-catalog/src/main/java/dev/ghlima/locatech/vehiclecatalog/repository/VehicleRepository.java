package dev.ghlima.locatech.vehiclecatalog.repository;

import dev.ghlima.locatech.vehiclecatalog.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
  List<Vehicle> findByAvailableTrue();
}
