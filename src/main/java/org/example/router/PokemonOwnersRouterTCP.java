package org.example.router;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PokemonOwnersRouterTCP extends Thread {

    private final PokemonOwnersHandler pokemonOwnersHandler;
    private final Socket socket;

    public PokemonOwnersRouterTCP(Socket socket) {
        this.pokemonOwnersHandler = new PokemonOwnersHandler();
        this.socket = socket;
    }

    public void run() {
        try(
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter outputWriter = new PrintWriter(socket.getOutputStream(), true)
        ) {
            String operation = inputReader.readLine();

            if(operation.matches("^pokemon-owner/\\d{8}$")) {
                String pokemonCode = operation.split("/")[1].trim();
                pokemonOwnersHandler.findByDni(pokemonCode, outputWriter);
            }

        } catch (Exception exception) {
            throw new IllegalArgumentException("Operation not found: " + exception.getMessage());

        } finally {
            try {
                if (socket != null) socket.close();
            } catch (Exception exception) {
                throw new RuntimeException("Error closing TCP connection: " + exception.getMessage());
            }
        }
    }

}

