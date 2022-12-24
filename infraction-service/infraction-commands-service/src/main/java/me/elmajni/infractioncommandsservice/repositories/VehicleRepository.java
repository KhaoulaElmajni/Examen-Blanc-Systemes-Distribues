package me.elmajni.infractioncommandsservice.repositories;

import me.elmajni.infractioncommandsservice.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,String> {
}
