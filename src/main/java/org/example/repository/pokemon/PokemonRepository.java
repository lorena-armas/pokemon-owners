package org.example.repository.pokemon;

import org.example.repository.pokemon.dao.PokemonDAO;
import org.example.repository.pokemon.dao.PokemonDAOImpl;
import org.example.repository.pokemon.wrapper.PokemonResponseWrapper;

public class PokemonRepository {

    private final PokemonDAO pokemonDAO;

    public PokemonRepository() {
        this.pokemonDAO = new PokemonDAOImpl();
    }

    public PokemonResponseWrapper findPokemon(String pokemonCode) {
        return pokemonDAO.findPokemon(pokemonCode);
    }
}
