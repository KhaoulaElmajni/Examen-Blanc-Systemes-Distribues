package me.elmajni.radarqueryservice.repositories;

import me.elmajni.radarqueryservice.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadarRepository extends JpaRepository<Radar,String> {
}
