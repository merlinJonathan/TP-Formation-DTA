package fr.dta.spring.boot.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ListeImagesController {

	@GetMapping("/tp/images/search/{year}/{month}/{day}")
	@ResponseBody
	public String triImage(@RequestParam(name="sort", required=false, defaultValue="Name") String sort, @PathVariable int year, @PathVariable int month, @PathVariable int day)
	{
		DateTimeFormatter formateur = DateTimeFormatter.ofPattern("dd MMMM YYYY");	
		LocalDate date = LocalDate.of(year, month, day);
		String resultat = "Liste des images du " + date.format(formateur) + " triées par " + sort;
		return resultat;
	}
}
