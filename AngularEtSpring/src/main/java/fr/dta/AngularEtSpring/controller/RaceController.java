package fr.dta.AngularEtSpring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.AngularEtSpring.dao.RaceDAO;
import fr.dta.AngularEtSpring.model.Race;

@RestController
@RequestMapping("/api/ponies")
public class RaceController {
	@Autowired
	RaceDAO racedao;
	
	@GetMapping("/")
    public List<Race> greeting() {
        return (List<Race>) racedao.findAll();
    }
	@GetMapping("/{id}")
    public Optional<Race> greeting(@PathVariable long id) {
        return racedao.findById(id);
    }
	
	@PostMapping("/addPonies")
    public void insertPony(@RequestParam(name="pony") Race race) {
		racedao.save(race);
    }
	
	@PutMapping("/updatePony")
    public void updatePony(@RequestParam(name="pony") Race race) {
		racedao.save(race);
    }
	
	@DeleteMapping("/deletePony")
    public void deletePony(@RequestParam(name="pony") long id) {
		racedao.deleteById(id);
    }
}
