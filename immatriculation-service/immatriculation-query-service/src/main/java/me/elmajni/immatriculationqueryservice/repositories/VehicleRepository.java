package me.elmajni.immatriculationqueryservice.repositories;


import me.elmajni.immatriculationqueryservice.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
}
