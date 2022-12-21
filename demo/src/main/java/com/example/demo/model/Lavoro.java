package com.example.demo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Table(name = "lavoro")
@Entity
public class Lavoro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String occupazione;

    @ManyToMany(mappedBy = "lavori")
    private Set<Person> persone = new HashSet<>();

    public void setPersone(Set<Person> persone) {
        this.persone = persone;
    }



    public Set<Person> getPersone() {
        return persone;
    }

    public void setOccupazione(String occupazione) {
        this.occupazione = occupazione;
    }

    public String getOccupazione() {
        return occupazione;
    }
}
