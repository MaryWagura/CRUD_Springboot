package com.example.app1.dao;

import com.example.app1.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{

 private static List<Person> DB = new ArrayList<>();
    @Override
    public int insertPerson(UUID Id, Person person) {
        DB.add(new Person(Id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID Id) {
        return DB.stream()
                .filter(person -> person.getId().equals(Id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID Id) {
       Optional<Person> personMaybe= selectPersonById(Id);
       if(personMaybe.isEmpty())
       {
           return 0;
       }
        DB.remove(personMaybe.get());
       return 1;
    }

    @Override
    public int updatePersonById(UUID Id, Person update) {
        return selectPersonById(Id)
                //select the person then map the person
                .map(person ->{
                    int indexOfPersonToUpdate = DB.indexOf(person);
                    //if person is found ie >0
                    if (indexOfPersonToUpdate > 0)
                    {
                        DB.set(indexOfPersonToUpdate, new Person(Id, update.getName()));
                        return 1;
                    }
                    return 0;
                    //if person does not exist
                }).orElse(0);

    }
}
