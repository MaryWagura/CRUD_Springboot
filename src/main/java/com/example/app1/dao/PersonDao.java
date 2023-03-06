package com.example.app1.dao;

import com.example.app1.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(UUID Id, Person person);

    default int insertPerson(Person person)
    {
        UUID Id= UUID.randomUUID();
        return insertPerson(Id,person );
    }
    List<Person> selectAllPeople();
    Optional<Person> selectPersonById(UUID Id);

    int deletePersonById(UUID Id);
    int updatePersonById(UUID Id, Person person);
}
