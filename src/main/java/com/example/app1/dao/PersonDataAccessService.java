package com.example.app1.dao;

import com.example.app1.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("mysql")
public class PersonDataAccessService implements PersonDao{
    @Override
    public int insertPerson(UUID Id, Person person) {
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        return List.of(new Person(UUID.randomUUID(), "FROM MYSQL DB"));
    }

    @Override
    public Optional<Person> selectPersonById(UUID Id) {
        return Optional.empty();
    }

    @Override
    public int deletePersonById(UUID Id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID Id, Person person) {
        return 0;
    }
}
