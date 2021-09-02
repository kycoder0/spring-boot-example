package com.trevdev.example.service;

import com.trevdev.example.dao.PersonDataAccess;
import com.trevdev.example.dto.Person;
import com.trevdev.example.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


// implementing business logic here
@Service
public class PersonService {

    private final PersonRepo personRepo;

    @Autowired
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    // map the data access objects back into pojos
    public List<Person> getAllPeople() {
        return this.personRepo.findAll().stream().map(personDao -> new Person(personDao.getId(), personDao.getName())).toList();
    }

    // insert person into the db
    public void insertPerson(String name) {
        PersonDataAccess personDao = new PersonDataAccess(UUID.randomUUID(), name);
        this.personRepo.save(personDao);
    }

    // insert many people
    public void insertMany(List<Person> people) {
        // stream people, map them to a DAO, then convert the resulting stream into a list to save in the repo
        this.personRepo.saveAll(people.stream()
                .map(person -> new PersonDataAccess(UUID.randomUUID(), person.getName()))
                .toList()
        );
    }
}
