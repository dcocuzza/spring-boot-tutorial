package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.aspectj.weaver.patterns.PerObject;
import org.hibernate.annotations.GenericGenerator;

import java.lang.Object;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Table(name = "person")
@Entity

public class Person {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")

    private UUID id;

    private String name;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "lavori_persone",
            joinColumns = { @JoinColumn(name = "id_persona") },
            inverseJoinColumns = { @JoinColumn(name = "id_lavoro") }
    )
    private Set<Lavoro> lavori = new HashSet<>();


    /*public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name)
    {
        this.id = id;
        this.name = name;

    }*/

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
