package com.example.loginauthapi.assembler;

import com.example.loginauthapi.domain.sutainable.Sutainable;
import com.example.loginauthapi.dto.SutainableDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SuitableAssembler {

    private final ModelMapper modelMapper;

    public List<SutainableDto> toCollectionModel(List<Sutainable> sutainableActions) {
        return sutainableActions.stream().map(this::toDto).toList();
    }

    public SutainableDto toDto(Sutainable sutainableAction){
        return modelMapper.map(sutainableAction, SutainableDto.class);
    }

    public Sutainable toResponse(SutainableActionResponse sutainableActionResponse){
        return modelMapper.map(sutainableActionResponse, Sutainable.class);
    }

}
