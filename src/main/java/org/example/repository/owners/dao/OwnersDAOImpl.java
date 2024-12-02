package org.example.repository.owners.dao;

import org.example.commons.CsvFileReader;
import org.example.repository.owners.entity.OwnersEntity;
import java.util.ArrayList;
import java.util.List;

public class OwnersDAOImpl implements OwnersDAO{

    private final String FILE = "/database/owners.csv";
    private static final char SEPARATOR = ',';


    @Override
    public List<OwnersEntity> findAll() {
        List<OwnersEntity> owners = new ArrayList<>();
        try {
            CsvFileReader.getRecords(FILE, SEPARATOR)
                    .forEach(csvRecord -> {

                      OwnersEntity owner = OwnersEntity.builder()
                              .dni(csvRecord.get("DNI"))
                              .name(csvRecord.get("NAME"))
                              .mainPokemonCode(csvRecord.get("MAIN_POKEMON_CODE"))
                              .build();

                      owners.add(owner);
                    });
        } catch (Exception exception) {
            throw new IllegalArgumentException("Error reading CSV", exception);
        }
        return owners;
    }

    @Override
    public OwnersEntity findByDni(String dni) {
        List<OwnersEntity> allPokemon = this.findAll();
        for (OwnersEntity pokemon: allPokemon) {
            if (pokemon.getDni().equals(dni)) {
                return pokemon;
            }
        }
        throw new IllegalArgumentException("No such pokemon");
    }
}
