package fr.dta.AngularEtSpring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.AngularEtSpring.dao.PonyDAO;
import fr.dta.AngularEtSpring.model.Pony;

@RestController
public class PonyController {
	@Autowired
	PonyDAO ponydao;
	
	@GetMapping("/")
    public List<Pony> greeting() {
        return (List<Pony>) ponydao.findAll();
    }
	@GetMapping("/{id}")
    public Optional<Pony> greeting(@PathVariable long id) {
        return ponydao.findById(id);
    }
	
	@PostMapping("/addPony")
    public void insertPony(@RequestBody Pony pony) {
        ponydao.save(pony);
    }
	
	@PutMapping("/updatePony")
    public void updatePony(@RequestBody Pony pony) {
		ponydao.save(pony);
    }
	
	@DeleteMapping("/deletePony")
    public void deletePony(@RequestBody long id) {
		ponydao.deleteById(id);
    }
	
}
