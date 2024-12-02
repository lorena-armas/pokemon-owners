package org.example.mapper;

import org.example.dto.PokemonDTO;
import org.example.dto.OwnerDTO;
import org.example.repository.owners.entity.OwnerEntity;
import org.example.repository.pokemon.wrapper.PokemonResponseWrapper;

public class PokemonOwnersMapper {

    public OwnerDTO toDTO(OwnerEntity owner, PokemonResponseWrapper pokemon) {
        return OwnerDTO.builder()
                .name(owner.getName())
                .dni(owner.getDni())
                .pokemon(PokemonDTO.builder()
                        .name(pokemon.getName())
                        .type(pokemon.getType())
                    .build())
                .build();
    }
}
