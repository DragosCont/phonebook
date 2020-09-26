package org.fasttrackit;

import org.fasttrackit.persistance.PersonRepository;
import org.fasttrackit.transfer.CreatePersonRequest;
import org.fasttrackit.transfer.UpdatePersonRequest;

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
//        request.setFirstName("Test2");
//        request.setLastName("Application2");
//        request.setDateAdded(LocalDate.now());
//        request.setPhoneNumber(1751234567);
//
//        personRepository.createPerson(request);
//
//       personRepository.deletePerson(1 );

//        UpdatePersonRequest request1 = new UpdatePersonRequest();
//        request1.setFirstName("Alina");
//        request1.setLastName("zzzzzz");
//        request1.setPhoneNumber(858858585);
//        request1.setDateUpdated(LocalDate.now().plusDays(2));
//
//        personRepository.updatePerson(2, request1);

        System.out.println(personRepository.getPersons());
    }

}
