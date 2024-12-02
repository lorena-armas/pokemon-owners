package org.example.mapper;

import org.example.dto.PokemonDTO;
import org.example.dto.OwnersDTO;
import org.example.repository.owners.entity.OwnersEntity;
import org.example.repository.pokemon.wrapper.PokemonResponseWrapper;

public class PokemonOwnersMapper {

    public OwnersDTO toDTO(OwnersEntity owner, PokemonResponseWrapper pokemon) {
        return OwnersDTO.builder()
                .name(owner.getName())
                .dni(owner.getDni())
                .pokemon(PokemonDTO.builder()
                        .name(pokemon.getName())
                        .code(pokemon.getCode())
                        .type(pokemon.getType())
                    .build())
                .build();
    }
}
