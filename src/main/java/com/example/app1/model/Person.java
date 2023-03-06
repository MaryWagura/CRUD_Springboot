package com.example.app1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;


import java.util.UUID;

public class Person {
    private final UUID Id;
    @NotBlank
    private final String Name;

    public Person(@JsonProperty("Id")UUID Id,
                  @JsonProperty("Name") String Name)
    {
        this.Id=Id;
        this.Name= Name;
    }
    public UUID getId() {
        return Id;
    }
    public String getName() {
        return Name;
    }
}
