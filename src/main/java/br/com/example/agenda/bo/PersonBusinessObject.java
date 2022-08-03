package br.com.example.agenda.bo;

import br.com.example.agenda.exception.PersonException;
import br.com.example.agenda.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonBusinessObject {
    public void validatePerson(Person person){

        if(person.getName()==null||
                person.getPhone()==null||
                person.getAddress()==null||
                person.getEmail()==null||
                person.getZipCode()==null){
            throw new PersonException();
        }
    }
}
