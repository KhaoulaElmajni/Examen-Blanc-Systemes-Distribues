package me.elmajni.infractioncommandsservice;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InfractionCommandsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfractionCommandsServiceApplication.class, args);
    }

    @Bean
    CommandBus commandBus(){
        return SimpleCommandBus.builder().build();
    }


}
