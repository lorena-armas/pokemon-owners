package org.example.service;

import org.example.dto.OwnersDTO;
import org.example.mapper.PokemonOwnerMapper;
import org.example.repository.owners.OwnersRepository;
import org.example.repository.owners.entity.OwnersEntity;
import org.example.repository.pokemon.PokemonRepository;
import org.example.repository.pokemon.wrapper.PokemonResponseWrapper;

public class PokemonOwnersServiceImpl implements PokemonOwnersService {

    private final PokemonOwnerMapper mapper;
    private final OwnersRepository ownersRepository;
    private final PokemonRepository pokemonRepository;

    public PokemonOwnersServiceImpl() {
        mapper = new PokemonOwnerMapper();
        ownersRepository = new OwnersRepository();
        pokemonRepository = new PokemonRepository();
    }
    @Override
    public OwnersDTO findByDni(String dni) {
        OwnersEntity owner = ownersRepository.findByDni(dni);
        PokemonResponseWrapper pokemon = pokemonRepository.findPokemon(owner.getMainPokemonCode());
        return mapper.toDTO(owner, pokemon);
    }
}
