package com.example.loginauthapi.controllers;

import com.example.loginauthapi.assembler.SuitableAssembler;
import com.example.loginauthapi.assembler.SutainableActionResponse;
import com.example.loginauthapi.domain.service.SutainableService;
import com.example.loginauthapi.domain.sutainable.Sutainable;
import com.example.loginauthapi.dto.SutainableDto;
import com.example.loginauthapi.repositories.SutainableRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suitable")
@RequiredArgsConstructor
public class SuitableController {

    private final SutainableRepository sutainableActionRepository;
    private final SuitableAssembler sutainableActionAssembler;
    private final SutainableService sutainableActionService;

    @GetMapping
    public List<SutainableDto> getAll(){
        return sutainableActionAssembler.toCollectionModel(sutainableActionRepository.findAll());
    }

    @GetMapping("/{sutainableActionId}")
    public ResponseEntity<SutainableDto> getSutainableActionById(@PathVariable String sutainableActionId){
        return sutainableActionRepository.findById(sutainableActionId)
                .map(sutainable -> ResponseEntity.ok(sutainableActionAssembler.toDto(sutainable)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SutainableDto saveSutainableAction(
            @Valid @RequestBody SutainableActionResponse sutainableActionResponse){

        Sutainable sutainableAction = sutainableActionAssembler.toResponse(sutainableActionResponse);
        Sutainable savedSutainableAction = sutainableActionService.saveSutainableAction(sutainableAction);

        return sutainableActionAssembler.toDto(savedSutainableAction);

    }

    @PutMapping("/{sutainableActionId}")
    public ResponseEntity<SutainableDto> updateSutainableAction(
            @Valid @RequestBody SutainableActionResponse sutainableActionResponse,
            @PathVariable String sutainableActionId){

        if (!sutainableActionRepository.existsById(sutainableActionId)){
            throw new RuntimeException("açao nao encontrada");
        }

        Sutainable updateAction = sutainableActionAssembler.toResponse(sutainableActionResponse);
        updateAction.setId(sutainableActionId);
        Sutainable updatedAction = sutainableActionService.saveSutainableAction(updateAction);

        return ResponseEntity.ok(sutainableActionAssembler.toDto(updatedAction));

    }

    @DeleteMapping("/{sutainableActionId}")
    public ResponseEntity<Void> deleteSutainableAction(@PathVariable String sutainableActionId){
        if (!sutainableActionRepository.existsById(sutainableActionId)){
            return ResponseEntity.notFound().build();
        }

        sutainableActionService.deleteSutainableAction(sutainableActionId);
        return ResponseEntity.noContent().build();
    }


}
