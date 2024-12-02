package org.example.repository.pokemon.dao;

import org.example.repository.pokemon.wrapper.PokemonResponseWrapper;

public interface PokemonDAO {

    PokemonResponseWrapper findPokemon(String pokemonCode);
}