package com.example.demo.service;

import com.example.demo.dao.PersonRepository;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    @Autowired
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository)
    {
        this.personRepository = personRepository;
    }
    public void addPerson(Person person)
    {
        personRepository.save(person);
    }

    public List<Person> getAllPeople(){
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(UUID id)
    {
        return personRepository.findById(id);
    }

    public void deletePerson(UUID id)
    {
        personRepository.deleteById(id);
    }

    public void updatePerson(UUID id, Person newPerson)
    {
        personRepository.deleteById(id);
        personRepository.save(newPerson);
    }

}
