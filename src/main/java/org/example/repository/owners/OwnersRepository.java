package org.example.repository.owners;

import org.example.repository.owners.dao.OwnersDAO;
import org.example.repository.owners.dao.OwnersDAOImpl;
import org.example.repository.owners.entity.OwnerEntity;
import java.util.List;

public class OwnersRepository {

    private final OwnersDAO ownersDAO;

    public OwnersRepository() {
        this.ownersDAO = new OwnersDAOImpl();
    }

    public List<OwnerEntity> findAll() {
        return ownersDAO.findAll();
    }

    public OwnerEntity findByDni(String dni) {
        return ownersDAO.findByDni(dni);
    }
}
