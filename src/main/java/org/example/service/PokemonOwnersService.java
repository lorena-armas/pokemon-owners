package org.example.service;

import org.example.dto.OwnersDTO;

public interface PokemonOwnersService {

    OwnersDTO findByDni(String dni);
}
