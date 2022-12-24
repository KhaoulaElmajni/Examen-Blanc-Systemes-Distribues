package me.elmajni.infractionqueryservice.services;

import lombok.extern.slf4j.Slf4j;
import me.elmajni.commonapi.GetContraventionsByNationalCardNumber;
import me.elmajni.infractionqueryservice.repositories.ContraventionRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ContraventionQueryHandler {
    private ContraventionRepository contraventionRepository;

    public ContraventionQueryHandler(ContraventionRepository contraventionRepository) {
        this.contraventionRepository = contraventionRepository;
    }

    @QueryHandler
    public Page on(GetContraventionsByNationalCardNumber query){
        log.info(query.getNationalCardNumber());
        if(query.getNationalCardNumber().equals(null) ||
        query.getNationalCardNumber().equals("") ||
        query.getNationalCardNumber().equals("undefined")){
            return contraventionRepository.findAll(PageRequest.of(query.getPage(),query.getSize()));
        }
        else return contraventionRepository.findAllByOwnerNationalCardId(query.getNationalCardNumber(), PageRequest.of(query.getPage(), query.getSize()));
    }
}
