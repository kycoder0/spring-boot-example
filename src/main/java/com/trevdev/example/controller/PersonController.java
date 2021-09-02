package com.trevdev.example.controller;

import com.trevdev.example.dto.Person;
import com.trevdev.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// this is where we define our endpoints
@RestController
// base request url
@RequestMapping("/api/v1/person")
public class PersonController {

    // inject our personService into this class
    @Autowired
    private PersonService personService;

    // GET localhost:8080/api/v1/person ->
    @GetMapping
    public List<Person> getPeople() {
       return this.personService.getAllPeople();
    }


    // POST localhost:8080/api/v1/person ->
    @PostMapping
    // this post requires a json body that corresponds to the person
    public void insertPerson(@RequestBody Person person) {
        this.personService.insertPerson(person.getName());
    }

    // extra function to add many people at a time
    @PostMapping("/many")
    // requires a list of person
    public void insertMany(@RequestBody List<Person> people) {
        this.personService.insertMany(people);
    }
}
