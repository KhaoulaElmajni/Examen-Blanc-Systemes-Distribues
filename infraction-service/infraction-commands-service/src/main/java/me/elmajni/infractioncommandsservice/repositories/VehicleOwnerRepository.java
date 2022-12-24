package me.elmajni.infractioncommandsservice.repositories;
import me.elmajni.infractioncommandsservice.model.VehicleOwner;
import org.springframework.data.jpa.repository.JpaRepository;
public interface VehicleOwnerRepository extends JpaRepository<VehicleOwner,String> {
}
