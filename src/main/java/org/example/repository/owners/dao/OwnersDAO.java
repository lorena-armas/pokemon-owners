package org.example.repository.owners.dao;

import org.example.repository.owners.entity.OwnersEntity;

import java.util.List;

public interface OwnersDAO {

    List<OwnersEntity> findAll();

    OwnersEntity findByDni(String dni);
}
