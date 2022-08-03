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
        return Person.builder()
                .name(personUpdateRequest.getName())
                .phone(personUpdateRequest.getPhone())
                .email(personUpdateRequest.getEmail())
                .address(personUpdateRequest.getAddress())
                .zipCode(personUpdateRequest.getZipCode())
                .build();
    }

    public Person convertSaveRequestToPerson(PersonSaveRequest personSaveRequest){
        return Person.builder()
                .name(personSaveRequest.getName())
                .email(personSaveRequest.getEmail())
                .phone(personSaveRequest.getPhone())
                .address(personSaveRequest.getAddress())
                .zipCode(personSaveRequest.getZipCode())
                .build();

    }
    public PersonResponse convertToPersonResponse(Person person){
        return PersonResponse.builder()
                .id(person.getId())
                .name(person.getName())
                .email(person.getEmail())
                .build();
    }

    public List<PersonResponse> convertToListPersonResponse(List<Person> personList) {
        return personList.stream()
                .map(this::convertToPersonResponse)
                .collect(Collectors.toList());
    }
}
