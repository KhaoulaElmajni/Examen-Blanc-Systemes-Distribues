package me.elmajni.immatriculationqueryservice.repositories;


import me.elmajni.immatriculationqueryservice.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    /*@Query("select v from Vehicle v where v.ownerShips = ?1")
    List<Vehicle> findbyOwnerId(String id);*/
}
