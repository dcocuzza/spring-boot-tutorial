package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@NonNull @RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople()
    {
        return personService.getAllPeople();
    }

    /*@GetMapping(path = "/{id}")
    public Person getPersonById(@PathVariable("id") UUID id)
    {
        return personService.getPersonById(id).orElse(null);
    }*/

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id)
    {
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @NonNull @RequestBody Person personToUpdate)
    {
        personService.updatePerson(id, personToUpdate);
    }

    @GetMapping(path = "/{let}")
    public @ResponseBody ResponseEntity<List<Person>> getNamesByChar(@PathVariable("let") char let) {
        try{
            List<Person> p = personService.getNamesByChar(let);
            if(p.isEmpty()) {
                System.out.println("Nessun record trovato");
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(p);


        }catch (Exception e)
        {
            System.out.println("ERROR: Input non valido");
            return ResponseEntity.badRequest().body(null);
        }

        //return ResponseEntity.badRequest().body("ERROR: input non valido");
    }
}
