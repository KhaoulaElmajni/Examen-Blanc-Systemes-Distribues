package me.elmajni.immatriculationqueryservice.controllers;

import lombok.AllArgsConstructor;
import me.elmajni.commonapi.GetAllRadarsQuery;
import me.elmajni.commonapi.GetAllVehiclesQuery;
import me.elmajni.commonapi.GetVehicleByRegistrationNumber;
import me.elmajni.commonapi.RadarResponseDTO;
import me.elmajni.immatriculationqueryservice.entities.Vehicle;
import me.elmajni.immatriculationqueryservice.entities.VehicleOwner;
import me.elmajni.immatriculationqueryservice.repositories.VehicleRepository;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/query/vehicle")
@AllArgsConstructor
@Service
public class VehicleQueryController {

        private QueryGateway queryGateway;
    private final VehicleRepository vehicleRepository;


    @GetMapping(path = "/all")
        public CompletableFuture<List<Vehicle>> getVehicles() {
            /*return queryGateway.query(new GetAllVehiclesQuery(),
                    ResponseTypes.multipleInstancesOf(Vehicle.class)).join();
             */
            return queryGateway.query(
                    new GetAllVehiclesQuery()
                    , ResponseTypes.multipleInstancesOf(Vehicle.class)
            );
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
