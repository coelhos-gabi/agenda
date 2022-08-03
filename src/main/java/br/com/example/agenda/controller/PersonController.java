package br.com.example.agenda.controller;

import br.com.example.agenda.converter.PersonConverter;
import br.com.example.agenda.exception.PersonException;
import br.com.example.agenda.model.Person;
import br.com.example.agenda.request.PersonSaveRequest;
import br.com.example.agenda.response.PersonResponse;
import br.com.example.agenda.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;
    private final PersonConverter personConverter;

    @Autowired
    public PersonController(PersonService personService, PersonConverter personConverter) {
        this.personService = personService;
        this.personConverter = personConverter;
    }
    @PostMapping
    public ResponseEntity<PersonResponse> save(@RequestBody PersonSaveRequest personRequest) throws URISyntaxException {

            var person = personConverter.convertSaveRequestToPerson(personRequest);
            var savedPerson = personService.save(person);
            var personResponse = personConverter.convertToPersonResponse(savedPerson);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(personResponse);

    }
    @GetMapping
    public ResponseEntity<List<PersonResponse>> findAll(){
        try{
            List<Person> personList = personService.findAll();
            List<PersonResponse> personResponseList = personConverter.convertToListPersonResponse(personList);
            return ResponseEntity.ok(personResponseList);

        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
