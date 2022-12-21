package com.example.demo.dao;

import com.example.demo.model.Lavoro;
import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LavoroRepository extends JpaRepository<Lavoro, Long> {

    @Query(value = "SELECT l.* FROM lavoro l, person p, lavori_persone lp WHERE p.name = ?1 AND p.id = lp.id_persona AND l.id = lp.id_lavoro", nativeQuery = true)
    List<Lavoro> findLavoroByNamePerson(String name);

    //void insertLavoriPersone(UUID id_person, Long id_lavoro);

}
