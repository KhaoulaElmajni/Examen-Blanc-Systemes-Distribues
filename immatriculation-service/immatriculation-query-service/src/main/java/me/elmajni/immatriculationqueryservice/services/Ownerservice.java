package me.elmajni.immatriculationqueryservice.services;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.elmajni.commonapi.GetAllOwners;
import me.elmajni.commonapi.GetOwner;
import me.elmajni.commonapi.OwnerCreatedEvent;
import me.elmajni.immatriculationqueryservice.entities.VehicleOwner;
import me.elmajni.immatriculationqueryservice.repositories.VehicleOwnerRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class Ownerservice {

        private VehicleOwnerRepository ownerRepository;

        @EventHandler
        @Transactional
        public void on(OwnerCreatedEvent event) {
            log.info("OwnerCreatedEvent: {}", event);
            VehicleOwner owner = new VehicleOwner();
            owner.setId(event.getId());
            owner.setOwnerName(event.getPayload().getName());
            owner.setOwnerAddress(event.getPayload().getAddress());
            owner.setOwnerEmail(event.getPayload().getEmail());
            owner.setOwnerNationalIdCard(event.getPayload().getNationalIdCard());
            owner.setOwnerPhoneNumber(event.getPayload().getPhoneNumber());
            ownerRepository.save(owner);
        }

        @QueryHandler
        public List<VehicleOwner> on(GetAllOwners query) {
            return ownerRepository.findAll();
        }

       /* @QueryHandler
        public VehicleOwner on(GetOwner query) {
            return ownerRepository.findById(query.get()).get();
        }*/

}

