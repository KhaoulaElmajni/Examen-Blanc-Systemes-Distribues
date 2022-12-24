package me.elmajni.immatriculationcommandsservice.aggregates;

import me.elmajni.commonapi.CreateOwnerCommand;
import me.elmajni.commonapi.OwnerCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

@Aggregate
public class OwnerAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private String nationalIdCard ;
    private String email ;
    private String phoneNumber ;
    private String address;

    public OwnerAggregate() {
        // Required by Axon
    }

    @CommandHandler
    public OwnerAggregate(CreateOwnerCommand command) {
        AggregateLifecycle.apply(new OwnerCreatedEvent(
                command.getId(),
                command.getPayload()
        ));
    }

    @EventSourcingHandler
    public void on(OwnerCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getPayload().getName();
        this.address = event.getPayload().getAddress();
        this.email = event.getPayload().getEmail();
        this.nationalIdCard = event.getPayload().getNationalIdCard();
        this.phoneNumber = event.getPayload().getPhoneNumber();
    }
}
