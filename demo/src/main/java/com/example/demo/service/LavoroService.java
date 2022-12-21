package com.example.demo.service;

import com.example.demo.dao.LavoroRepository;
import com.example.demo.model.Lavoro;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LavoroService {

    @Autowired
    private final LavoroRepository lavoroRepository;

    @Autowired
    public LavoroService(LavoroRepository lavoroRepository){
        this.lavoroRepository = lavoroRepository;
    }

    public void addLavoro(Lavoro lavoro)
    {
        lavoroRepository.save(lavoro);
    }

    public List<Lavoro> getAllLavori(){
        return lavoroRepository.findAll();
    }

    public Optional<Lavoro> getLavoroById(Long id)
    {
        return lavoroRepository.findById(id);
    }

    public void deleteLavoro(Long id)
    {
        lavoroRepository.deleteById(id);
    }

    public void updateLavoro(Long id, Lavoro newLavoro)
    {
        lavoroRepository.deleteById(id);
        lavoroRepository.save(newLavoro);
    }

   public List<Lavoro> findLavoroByNamePerson(String name){
        return lavoroRepository.findLavoroByNamePerson(name);
    }

    /*public void insertLavoriPersone(UUID id_person, Long id_lavoro)
    {
        lavoroRepository.insertLavoriPersone(id_person, id_lavoro);
    }*/

}
