package com.example.demo.api;

import com.example.demo.model.Lavoro;
import com.example.demo.service.LavoroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/lavoro")
@RestController
public class LavoroController {

    @Autowired
    private final LavoroService lavoroService;

    @Autowired
    public LavoroController(LavoroService lavoroService) {
        this.lavoroService = lavoroService;
    }

    @PostMapping
    public void addLavoro(@NonNull @RequestBody Lavoro lavoro){
        lavoroService.addLavoro(lavoro);
    }

    @GetMapping
    public List<Lavoro> getAllLavori()
    {
        return lavoroService.getAllLavori();
    }

   /* @GetMapping(path = "/{id}")
    public Lavoro getLavoroById(@PathVariable("id") Long id)
    {
        return lavoroService.getLavoroById(id).orElse(null);
    }*/

    @DeleteMapping(path = "{id}")
    public void deleteLavoroById(@PathVariable("id") Long id)
    {
        lavoroService.deleteLavoro(id);
    }

    @PutMapping(path = "{id}")
    public void updateLavoro(@PathVariable("id") Long id, @NonNull @RequestBody Lavoro lavoroToUpdate)
    {
        lavoroService.updateLavoro(id, lavoroToUpdate);
    }

    @GetMapping(path = "/{name}")
    public List<Lavoro> getLavoroById(@PathVariable("name") String name)
    {
        return lavoroService.findLavoroByNamePerson(name);
    }
}
