package br.com.example.agenda.repository;

import br.com.example.agenda.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
