package br.com.example.agenda.service;

import br.com.example.agenda.bo.PersonBusinessObject;
import br.com.example.agenda.model.Person;
import br.com.example.agenda.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonBusinessObject personBusinessObject;

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonBusinessObject personBusinessObject, PersonRepository personRepository) {
        this.personBusinessObject = personBusinessObject;
        this.personRepository = personRepository;
    }

    public Person save(Person person){
        personBusinessObject.validatePerson(person);
        return personRepository.save(person);
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }
    public Person update(Person person){
        return personRepository.save(person);
    }

    public void delete(Person person){
        personRepository.delete(person);
    }
}
