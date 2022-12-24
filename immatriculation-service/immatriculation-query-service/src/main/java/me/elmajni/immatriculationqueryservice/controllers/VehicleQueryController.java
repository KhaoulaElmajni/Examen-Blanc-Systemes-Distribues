package me.elmajni.immatriculationqueryservice.controllers;

import lombok.AllArgsConstructor;
import me.elmajni.commonapi.GetAllVehiclesQuery;
import me.elmajni.commonapi.GetVehicleByRegistrationNumber;
import me.elmajni.immatriculationqueryservice.entities.Vehicle;
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
@RequestMapping("/query/vehicule")
@AllArgsConstructor
@Service
public class VehicleQueryController {

        private QueryGateway queryGateway;


        @GetMapping(path = "/")
        public List<Vehicle> getVehicules() {
            return queryGateway.query(new GetAllVehiclesQuery(), ResponseTypes.multipleInstancesOf(Vehicle.class)).join();
        }

        @GetMapping(path = "/{id}")
        public VehicleOwner getVehicule(@PathVariable String id) {
            return queryGateway.query(new GetVehicleByRegistrationNumber(id), VehicleOwner.class).join();
        }

        /*@GetMapping(path = "/byRegistrationNumber/{number}")
        public List<InfractionResponseDTO> getVehiculeByMatricule(@PathVariable String number) {
            return queryGateway.query(new GetInfractionsByVehicle(matricule), ResponseTypes.multipleInstancesOf(InfractionResponseDTO.class)).join();
        }*/
}
