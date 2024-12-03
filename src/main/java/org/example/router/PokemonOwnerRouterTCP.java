package org.example.router;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PokemonOwnerRouterTCP extends Thread {

    private final PokemonOwnerHandler pokemonOwnerHandler;
    private final Socket socket;

    public PokemonOwnerRouterTCP(Socket socket) {
        this.pokemonOwnerHandler = new PokemonOwnerHandler();
        this.socket = socket;
    }

    public void run() {
        try(
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter outputWriter = new PrintWriter(socket.getOutputStream(), true)
        ) {
            String operation = inputReader.readLine();

            if(operation.matches("^pokemon-owners/\\d{8}$")) {
                String pokemonCode = operation.split("/")[1].trim();
                pokemonOwnerHandler.findByDni(pokemonCode, outputWriter);
            }

        } catch (Exception exception) {
            throw new IllegalArgumentException("error message : " + exception.getMessage());

        } finally {
            try {
                if (socket != null) socket.close();
            } catch (Exception exception) {
                throw new RuntimeException("Error closing TCP connection: " + exception.getMessage());
            }
        }
    }

}

