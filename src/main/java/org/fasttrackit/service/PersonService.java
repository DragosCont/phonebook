package org.fasttrackit.service;

import org.fasttrackit.domain.Person;
import org.fasttrackit.persistance.PersonRepository;
import org.fasttrackit.transfer.CreatePersonRequest;
import org.fasttrackit.transfer.UpdatePersonRequest;

import java.sql.SQLException;
import java.util.List;

public class PersonService {

    private PersonRepository personRepository = new PersonRepository();

    public void createPerson(CreatePersonRequest request) throws SQLException {
        System.out.println("Creating person: " + request);
        personRepository.createPerson(request);
    }

    public List<Person> getPersons() throws SQLException {
        System.out.println("Retrieving persons.");
        return personRepository.getPersons();
    }

    public void updatePerson(long id, UpdatePersonRequest request) throws SQLException {
        System.out.println("Updating person " + id +": "+ request);
        personRepository.updatePerson(id, request);
    }

    public void deletePerson (long id) throws SQLException {
        System.out.println("Deleting person: " + id);
        personRepository.deletePerson(id);
    }
}
