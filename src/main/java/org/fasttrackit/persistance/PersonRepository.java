package org.fasttrackit.persistance;

import org.fasttrackit.config.DatabaseConfiguration;
import org.fasttrackit.transfer.CreatePersonRequest;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonRepository {

    public void createPerson (CreatePersonRequest request) throws SQLException {

        String sql = "INSERT INTO person (first_name, last_name, phone_number, date_added) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = DatabaseConfiguration.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, request.getFirstName());
            preparedStatement.setString(2, request.getLastName());
            preparedStatement.setInt(3, request.getPhoneNumber());
            preparedStatement.setDate(4, Date.valueOf(request.getDateAdded()));

            preparedStatement.executeUpdate();
        }

    }

    public void deletePerson (long id) throws SQLException {

        String sql = "DELETE FROM person WHERE id = ?";

        try (PreparedStatement preparedStatement = DatabaseConfiguration.getConnection().prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        }
    }
}
