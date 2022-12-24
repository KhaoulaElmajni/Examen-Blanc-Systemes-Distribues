package me.elmajni.immatriculationqueryservice.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.elmajni.commonapi.GetAllVehiclesQuery;
import me.elmajni.commonapi.GetVehicleByOwner;
import me.elmajni.commonapi.GetVehicleByRegistrationNumber;
import me.elmajni.commonapi.VehicleCreatedEvent;
import me.elmajni.immatriculationqueryservice.entities.Vehicle;
import me.elmajni.immatriculationqueryservice.entities.VehicleOwner;
import me.elmajni.immatriculationqueryservice.repositories.VehicleOwnerRepository;
import me.elmajni.immatriculationqueryservice.repositories.VehicleRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class VehicleService {
        private VehicleRepository vehiculeRepository;
        private VehicleOwnerRepository ownerRepository;

        @EventHandler
        @Transactional
        public void on(VehicleCreatedEvent event) {
            log.info("VehicleCreatedEvent: {}", event);
            VehicleOwner owner = ownerRepository.findById(event.getPayload().getRegistrationNumber()).get();
            Vehicle vehicule = new Vehicle();
            vehicule.setRegistrationNumber(event.getId());
            vehicule.setType(event.getPayload().getType());
            vehicule.setBrand(event.getPayload().getBrand());
            vehicule.setModel(event.getPayload().getModel());
            vehiculeRepository.save(vehicule);
        }


        @QueryHandler
        public List<Vehicle> on(GetAllVehiclesQuery query) {
            return vehiculeRepository.findAll();
        }

        @QueryHandler
        public Vehicle on(GetVehicleByRegistrationNumber query) {
            return vehiculeRepository.findById(query.getRegistrationNumber()).get();
        }

        /*@QueryHandler
        public List<Vehicle> on(GetVehicleByOwner query) {
            return vehiculeRepository.findByProprietaireIdEquals(query.getId());
        }*/

    }

