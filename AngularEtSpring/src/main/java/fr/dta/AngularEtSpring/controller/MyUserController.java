package fr.dta.AngularEtSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.AngularEtSpring.dao.MyUserDAO;
import fr.dta.AngularEtSpring.model.MyUser;

@RestController
@RequestMapping("/api/users")
public class MyUserController {

	@Autowired
	private MyUserDAO myuserdao;

	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	public MyUser findById(@PathVariable long id) {
		return myuserdao.findById(id);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/")
	public List<MyUser> findAllUsers() {
		return myuserdao.findAll();
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/addUser")
	public void create(@RequestBody MyUser user) {
		myuserdao.insert(user);
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/updateUser")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public void update(@RequestBody MyUser resource) {
		myuserdao.update(resource);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/deleteUser/{id}")
	public void deleteById(@PathVariable long id) {
		myuserdao.delete(id);
	}
}