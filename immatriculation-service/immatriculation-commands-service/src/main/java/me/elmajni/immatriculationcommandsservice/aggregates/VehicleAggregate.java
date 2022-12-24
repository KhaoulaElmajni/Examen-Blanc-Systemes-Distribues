package me.elmajni.immatriculationcommandsservice.aggregates;

import lombok.extern.slf4j.Slf4j;
import me.elmajni.commonapi.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.spring.stereotype.Aggregate;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Aggregate
@Slf4j
public class VehicleAggregate {
    @AggregateIdentifier
    private String registrationNumber;
    private VehicleType type ;
    private String brand;
    private String model;
    private int fiscalPower ;
    private String ownerName ;
    private String ownerNationalIdCard;
    private String ownerEmail ;
    private String ownerPhoneNumber ;
    private String ownerAddress;

    public VehicleAggregate() {
        // Required by Axon
    }

    @CommandHandler
    public VehicleAggregate(CreateVehicleCommand command) {

        AggregateLifecycle.apply(new VehicleCreatedEvent(
                command.getId(),
                command.getPayload()));
    }


    @EventSourcingHandler
    public void on(VehicleCreatedEvent event) {
        this.registrationNumber = event.getId();
        this.type = event.getPayload().getType();
        this.brand = event.getPayload().getBrand();
        this.model = event.getPayload().getModel();
        this.fiscalPower = event.getPayload().getFiscalPower();
        this.ownerName = event.getPayload().getOwnerName();
        this.ownerNationalIdCard = event.getPayload().getOwnerNationalIdCard();
        this.ownerEmail = event.getPayload().getOwnerEmail();
        this.ownerPhoneNumber = event.getPayload().getOwnerPhoneNumber();
        this.ownerAddress = event.getPayload().getOwnerAddress();
    }
}
