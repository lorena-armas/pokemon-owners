package org.example.service;

import org.example.dto.OwnerDTO;
import org.example.mapper.PokemonOwnersMapper;
import org.example.repository.owners.OwnersRepository;
import org.example.repository.owners.entity.OwnerEntity;
import org.example.repository.pokemon.PokemonRepository;
import org.example.repository.pokemon.wrapper.PokemonResponseWrapper;

public class PokemonOwnerServiceImpl implements PokemonOwnerService {

    private final PokemonOwnersMapper mapper;
    private final OwnersRepository ownersRepository;
    private final PokemonRepository pokemonRepository;

    public PokemonOwnerServiceImpl() {
        mapper = new PokemonOwnersMapper();
        ownersRepository = new OwnersRepository();
        pokemonRepository = new PokemonRepository();
    }

    @Override
    public OwnerDTO findByDni(String dni) {
        OwnerEntity owner = ownersRepository.findByDni(dni);
        PokemonResponseWrapper pokemon = pokemonRepository.findByCode(owner.getMainPokemonCode());
        return mapper.toDTO(owner, pokemon);
    }
}
