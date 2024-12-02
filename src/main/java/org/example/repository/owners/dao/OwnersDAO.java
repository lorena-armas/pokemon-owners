package org.example.repository.owners.dao;

import org.example.repository.owners.entity.OwnerEntity;

import java.util.List;

public interface OwnersDAO {

    List<OwnerEntity> findAll();

    OwnerEntity findByDni(String dni);
}
