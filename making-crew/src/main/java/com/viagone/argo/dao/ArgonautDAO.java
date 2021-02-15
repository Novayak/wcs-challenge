package com.viagone.argo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.viagone.argo.model.Argonaut;

public class ArgonautDAO {

    private DataSource datasource;

    public ArgonautDAO(DataSource datasource) {
        this.datasource = datasource;
    }
    
    /**
     * 
     * @return crew:  a list of Argonaut
     * @throws SQLException
     * @throws Exception
     */
    public List<Argonaut> findAll() throws SQLException, Exception {

        List<Argonaut> crew = new ArrayList<>();

        try (
            Connection connection = this.datasource.getConnection();
            PreparedStatement statement =
                connection.prepareStatement("select fullname from crew order by id;");
        ) {
            try (ResultSet results = statement.executeQuery()) {
                while(results.next()) {
                    Argonaut newMember = new Argonaut();
                    newMember.setId(results.getLong(1));
                    newMember.setFullname(results.getString(2));
                    crew.add(newMember);
                }
            }
        }
        return crew;
    }
    /**
     * 
     * @param argonaut the object to be saved in DB
     * @throws SQLException
     * @throws Exception
     */
    public void saveCrewman(Argonaut argonaut) throws SQLException, Exception {
        try (
            Connection connection = this.datasource.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO crew (fullname) VALUES (?)",
                Statement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, argonaut.getFullname());
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException(
                    "Argonaut creation failed, no rows affected");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    argonaut.setId(generatedKeys.getLong(1));
                }
                else {
                    throw new SQLException(
                        "Argonaut creation failed, no id obtained");
                }
            }
        }

    }
}