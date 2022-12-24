package me.elmajni.immatriculationcommandsservice.controllers;

import lombok.extern.slf4j.Slf4j;
import me.elmajni.commonapi.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@Slf4j
@RequestMapping("/commands")
@CrossOrigin("*")
public class VehicleCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;

    public VehicleCommandController(CommandGateway commandGateway, EventStore eventStore) {
        this.commandGateway = commandGateway;
        this.eventStore = eventStore;
    }
    @PostMapping("/vehicle/create")
    public CompletableFuture<String> addNewVehicleCommand(@RequestBody VehicleRequestDTO request){
        return this.commandGateway.send(new CreateVehicleCommand(
                UUID.randomUUID().toString(),
                request
        ));
    }
    @GetMapping("/eventStore/{id}")
    public Stream streamEvents(@PathVariable String id){
        return eventStore.readEvents(id).asStream();
    }


}
