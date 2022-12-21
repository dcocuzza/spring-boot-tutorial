package com.example.demo.service;

import com.example.demo.dao.PersonRepository;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public boolean validate(char lettera)
    {
        if(((int)lettera >= 65 && (int)lettera <= 90) || ((int)lettera >= 97 && (int)lettera <= 122))
            return true;
        return false;
    }

    public List<Person> getNamesByChar(char lettera)
    {
        List<Person> p;
        boolean valida = validate(lettera);
        if(valida)
        {
            p = personRepository.getNamesByChar(lettera);
            return p;
        }

        return null;
    }

}
