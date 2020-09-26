package org.fasttrackit.persistance;

import org.fasttrackit.config.DatabaseConfiguration;
import org.fasttrackit.domain.Person;
import org.fasttrackit.transfer.CreatePersonRequest;
import org.fasttrackit.transfer.UpdatePersonRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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


    public void updatePerson (long id, UpdatePersonRequest request) throws SQLException {
        String sql = "UPDATE person SET first_name=?, last_name=?, phone_number=?, date_updated=? WHERE id = ?";

        try (PreparedStatement preparedStatement = DatabaseConfiguration.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, request.getFirstName());
            preparedStatement.setString(2, request.getLastName());
            preparedStatement.setInt(3, request.getPhoneNumber());
            preparedStatement.setDate(4, Date.valueOf(request.getDateUpdated()));
            preparedStatement.setLong(5, id);

            preparedStatement.executeUpdate();
        }

    }

    public List<Person> getPersons () throws SQLException {
        String sql = "SELECT id, first_name, last_name, phone_number, date_added, date_updated FROM person";

        List<Person> persons = new ArrayList<>();
        try (Statement statement = DatabaseConfiguration.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getLong("id"));
                person.setFirstName(resultSet.getString("first_name"));
                person.setLastName(resultSet.getString("last_name"));
                person.setPhoneNumber(resultSet.getInt("phone_number"));
                person.setDateAdded(resultSet.getDate("date_added").toLocalDate());
//                person.setDateUpdated(resultSet.getDate("date_updated").toLocalDate());

                persons.add(person);
            }
        }
        return persons;
    }
}
