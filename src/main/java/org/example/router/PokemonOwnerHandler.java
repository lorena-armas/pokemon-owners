package org.example.router;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.OwnersDTO;
import org.example.service.PokemonOwnersService;
import org.example.service.PokemonOwnersServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;

public class PokemonOwnerHandler {

    private final static ObjectMapper objectMapper = new ObjectMapper();
    private final PokemonOwnersService pokemonOwnersService;

    public PokemonOwnerHandler() {
        this.pokemonOwnersService = new PokemonOwnersServiceImpl();
    }

    public void findByDni(String dni, PrintWriter output) throws IOException {
        OwnersDTO pokemonOwner = pokemonOwnersService.findByDni(dni);
        String pokemonOwnerJson = objectMapper.writeValueAsString(pokemonOwner);

        output.println(pokemonOwnerJson);
    }

}
