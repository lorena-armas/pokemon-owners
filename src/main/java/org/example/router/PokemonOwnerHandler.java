package org.example.router;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.OwnerDTO;
import org.example.service.PokemonOwnerService;
import org.example.service.PokemonOwnerServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;

public class PokemonOwnerHandler {

    private final static ObjectMapper objectMapper = new ObjectMapper();
    private final PokemonOwnerService pokemonOwnersService;

    public PokemonOwnerHandler() {
        this.pokemonOwnersService = new PokemonOwnerServiceImpl();
    }

    public void findByDni(String dni, PrintWriter output) throws IOException {
        OwnerDTO pokemonOwner = pokemonOwnersService.findByDni(dni);
        String pokemonOwnerJson = objectMapper.writeValueAsString(pokemonOwner);

        output.println(pokemonOwnerJson);
    }

}
