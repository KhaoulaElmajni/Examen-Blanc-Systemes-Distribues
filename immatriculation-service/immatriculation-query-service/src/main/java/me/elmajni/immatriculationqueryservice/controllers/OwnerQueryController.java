package me.elmajni.immatriculationqueryservice.controllers;

import lombok.AllArgsConstructor;
import me.elmajni.commonapi.GetAllOwners;
import me.elmajni.commonapi.GetOwner;
import me.elmajni.immatriculationqueryservice.entities.VehicleOwner;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/query/owner")
@AllArgsConstructor
@Service
public class OwnerQueryController {
    private QueryGateway queryGateway;


    @GetMapping(path = "/")
    public List<VehicleOwner> getOwner() {
        return queryGateway.query(new GetAllOwners(), ResponseTypes.multipleInstancesOf(VehicleOwner.class)).join();
    }

    @GetMapping(path = "/{id}")
    public VehicleOwner getOwner(@PathVariable String id) {
        return queryGateway.query(new GetOwner(id), VehicleOwner.class).join();
    }

    /*@GetMapping(path = "/infraction/{id}")
    public List<InfractionResponseDTO> getInfractionsByOwnerId(@PathVariable String id) {
        List<Vehicule> vehicules = queryGateway.query(new GetVehiculesByOwnerId(id), ResponseTypes.multipleInstancesOf(Vehicule.class)).join();
        List<InfractionResponseDTO> infractionResponseDTOS = new ArrayList<>();
        for (Vehicule vehicule : vehicules) {
            infractionResponseDTOS.addAll(queryGateway.query(new GetInfractionsByVehicle(vehicule.getMatricule()), ResponseTypes.multipleInstancesOf(InfractionResponseDTO.class)).join());
        }
        return infractionResponseDTOS;
    }*/
}