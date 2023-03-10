package com.example.app1.service;

import com.example.app1.dao.PersonDao;
import com.example.app1.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;
     @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }
//    public PersonService(@Qualifier("mysql") PersonDao personDao) {
//        this.personDao = personDao;
//    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }
    public List<Person> getAllPeople()
    {
        return personDao.selectAllPeople();
    }
    public Optional<Person> getPersonById(UUID Id)
    {
        return personDao.selectPersonById(Id);
    }
    public int deletePerson(UUID Id)
    {
        return personDao.deletePersonById(Id);
    }
    public int updatePerson(UUID Id, Person newPerson)
    {
        return personDao.updatePersonById(Id, newPerson);
    }
}
