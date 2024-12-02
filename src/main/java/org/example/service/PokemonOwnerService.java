package org.example.service;

import org.example.dto.OwnerDTO;

public interface PokemonOwnerService {

    OwnerDTO findByDni(String dni);
}
