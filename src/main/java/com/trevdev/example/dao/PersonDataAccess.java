package com.trevdev.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.util.UUID;


// this is the entity which can be stored into the repo
@Entity
@Table(name = "person")
public class PersonDataAccess {
    @Id
    @Column(name="id")
    private UUID id;

    @Column(name="name")
    private String name;

    // jpa requires default constructor
    public PersonDataAccess() {

    }
    public PersonDataAccess(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
