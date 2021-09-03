package com.trevdev.example.controller;

import com.trevdev.example.dto.Person;
import com.trevdev.example.service.PersonService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    // rate limit this endpoint, config for rate limit is in application.yml
    // fallback is used when this method is rate limited
    @RateLimiter(name="getPeople", fallbackMethod = "getPeopleFallback")
    // limit the amount of concurrent calls on this endpoint
    @Bulkhead(name="getPeople",  fallbackMethod = "getPeopleFallbackBulkhead")
    public ResponseEntity<List<Person>> getPeople() {
        try {
            Thread.sleep(3000);
        }
        catch (Exception e) {

        }
        List<Person> allPeople = this.personService.getAllPeople();
        return new ResponseEntity<>(allPeople, null, HttpStatus.OK);
    }

    // return the "too many requests" http status code
    public ResponseEntity<List<Person>> getPeopleFallback(Throwable throwable) {
        return new ResponseEntity<>(null, null, HttpStatus.TOO_MANY_REQUESTS);
    }
    // quests" http status code
    public ResponseEntity<List<Person>> getPeopleFallbackBulkhead(Throwable throwable) {
        return new ResponseEntity<>(null, null, HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
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
