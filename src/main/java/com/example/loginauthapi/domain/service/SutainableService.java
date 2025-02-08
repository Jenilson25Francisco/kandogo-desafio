package com.example.loginauthapi.domain.service;

import com.example.loginauthapi.domain.sutainable.Category;
import com.example.loginauthapi.domain.sutainable.Sutainable;
import com.example.loginauthapi.repositories.SutainableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class SutainableService {

    private final SutainableRepository sutainableActionRepository;


    @Transactional
    public Sutainable saveSutainableAction(Sutainable sutainableAction){

        sutainableAction.setCreatedAt(OffsetDateTime.now());
        sutainableAction.setCategory(Category.MOBILIDADE);

        return sutainableActionRepository.save(sutainableAction);
    }

    @Transactional
    public void deleteSutainableAction(String sutainableActionId){
        sutainableActionRepository.deleteById(sutainableActionId);
    }


}
