package org.example.repository.owners.dao;

import org.example.commons.MySQLConnection;
import org.example.repository.owners.entity.OwnersEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OwnerMySQLDAOImpl implements OwnersDAO{

    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet result;

    @Override
    public List<OwnersEntity> findAll() {
        try {
            connection = MySQLConnection.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("SELECT code, name, document_identification FROM owners;");
            result = statement.executeQuery();

            List<OwnersEntity> ownerList = new ArrayList<>();
            while (result.next()) {
                OwnersEntity ownersEntity = new OwnersEntity();
                ownersEntity.setDni(result.getString("document_identification"));
                ownersEntity.setName(result.getString("name"));
                ownersEntity.setMainPokemonCode(result.getString("code"));

                ownerList.add(ownersEntity);
            }
            connection.commit();
            return ownerList;

        } catch (Exception exception) {
            rollback();
            throw new RuntimeException("error to find all owners: " + exception.getMessage());
        } finally {
            closeResources();
        }
    }

    @Override
    public OwnersEntity findByDni(String dni) {
        try {
            connection = MySQLConnection.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("SELECT code, name, document_identification, main_pokemon_code FROM owners WHERE document_identification = ?");
            statement.setString(1, dni);
            result = statement.executeQuery();

            OwnersEntity owner = new OwnersEntity();
            if (result.next()) {
                owner.setCode(result.getInt("code"));
                owner.setMainPokemonCode(result.getString("main_pokemon_code"));
                owner.setName(result.getString("name"));
                owner.setDni(result.getString("document_identification"));
            }
            connection.commit();
            return owner;

        } catch (Exception exception) {
            rollback();
            throw new RuntimeException("error to find owner by dni:" + exception.getMessage());
        } finally {
            closeResources();
        }
    }

    private void rollback() {
        try {
            if (connection != null) {
                connection.rollback();
            }
        } catch (Exception exception) {
            throw new RuntimeException("error to rollback: " + exception.getMessage());
        }
    }

    private void closeResources() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (result != null) {
                result.close();
            }
        } catch (Exception exception) {
            throw new RuntimeException("error to close resources: " + exception.getMessage());
        }
    }
}
