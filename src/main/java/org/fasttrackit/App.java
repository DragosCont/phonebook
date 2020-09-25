package org.fasttrackit;

import org.fasttrackit.persistance.PersonRepository;
import org.fasttrackit.transfer.CreatePersonRequest;

import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        System.out.println( "Hello World!" );


        PersonRepository personRepository = new PersonRepository();

//        CreatePersonRequest request = new CreatePersonRequest();
//        request.setFirstName("Test");
//        request.setLastName("Application");
//        request.setPhoneNumber(1751234567);
//        request.setDateAdded(LocalDate.now());
//
//        personRepository.createPerson(request);

        personRepository.deletePerson(3);
    }

}
