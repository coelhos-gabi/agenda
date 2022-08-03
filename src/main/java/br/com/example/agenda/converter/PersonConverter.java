package br.com.example.agenda.converter;

import br.com.example.agenda.model.Person;
import br.com.example.agenda.request.PersonSaveRequest;
import br.com.example.agenda.response.PersonResponse;
import br.com.example.agenda.request.PersonUpdateRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonConverter {

    public Person convertUpdateRequestToPerson(PersonUpdateRequest personUpdateRequest){
        var person = new Person();
        person.setName(personUpdateRequest.getName());
        person.setPhone(personUpdateRequest.getPhone());
        person.setEmail(personUpdateRequest.getEmail());
        person.setAddress(personUpdateRequest.getAddress());
        person.setZipCode(personUpdateRequest.getZipCode());

        return person;
    }

    public Person convertSaveRequestToPerson(PersonSaveRequest personSaveRequest){
        var person = new Person();
        person.setName(personSaveRequest.getName());
        person.setPhone(personSaveRequest.getPhone());
        person.setEmail(personSaveRequest.getEmail());
        person.setAddress(personSaveRequest.getAddress());
        person.setZipCode(personSaveRequest.getZipCode());

        return person;
    }
    public PersonResponse convertToPersonResponse(Person person){
        var personResponse = new PersonResponse();
        personResponse.setId(person.getId());
        personResponse.setName(person.getName());
        personResponse.setPhone(person.getPhone());
        personResponse.setEmail(person.getEmail());
        personResponse.setAddress(person.getAddress());
        personResponse.setZipCode(person.getZipCode());

        return personResponse;
    }

    public List<PersonResponse> convertToListPersonResponse(List<Person> personList) {
        return personList.stream()
                .map(this::convertToPersonResponse)
                .collect(Collectors.toList());
    }
}
