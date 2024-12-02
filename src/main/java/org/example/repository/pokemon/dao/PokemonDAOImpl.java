package org.example.repository.pokemon.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.commons.PropertiesReader;
import org.example.repository.pokemon.wrapper.PokemonResponseWrapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PokemonDAOImpl implements PokemonDAO {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final PropertiesReader propertiesReader;

    public PokemonDAOImpl() {
        this.propertiesReader = new PropertiesReader();
    }

    @Override
    public PokemonResponseWrapper findPokemon(String pokemonCode) {
        Socket socket = null;
        PrintWriter outputWriter = null;
        BufferedReader inputReader = null;

        try {
            String host = propertiesReader.getProperty("services.pokemones.host");
            int port = Integer.parseInt(propertiesReader.getProperty("services.pokemones.port"));
            socket = new Socket(host, port);

            outputWriter = new PrintWriter(socket.getOutputStream(),true);
            inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            outputWriter.println("pokemon/" + pokemonCode);

            String pokemonJson = inputReader.readLine();
            return objectMapper.readValue(pokemonJson, PokemonResponseWrapper.class);

        } catch (Exception exception) {
            throw new RuntimeException("Error processing pokemon: " + exception.getMessage());

        } finally {
            try {
                if (inputReader != null) inputReader.close();
                if (outputWriter != null) outputWriter.close();
                if (socket != null) socket.close();

            } catch (Exception exception) {
                throw new RuntimeException("Error closing TCP connection: " + exception.getMessage());
            }
        }
    }
}
