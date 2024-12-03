package org.example.repository.owners;

import org.example.repository.owners.dao.OwnerMySQLDAOImpl;
import org.example.repository.owners.dao.OwnersDAO;
import org.example.repository.owners.entity.OwnersEntity;
import java.util.List;

public class OwnersRepository {

    private final OwnersDAO ownersDAO;

    public OwnersRepository() {
        this.ownersDAO = new OwnerMySQLDAOImpl();
    }

    public List<OwnersEntity> findAll() {
        return ownersDAO.findAll();
    }

    public OwnersEntity findByDni(String dni) {
        return ownersDAO.findByDni(dni);
    }
}
