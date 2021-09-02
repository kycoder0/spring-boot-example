package com.trevdev.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

// this class is used for request body's and to be used throughout our code
public class Person {
    private final UUID id;
    private final String name;

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

