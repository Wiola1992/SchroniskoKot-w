package pl.schronisko.kontroler;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import pl.schronisko.application.kotDAO;
import pl.schronisko.domain.cat;
import pl.schronisko.kontroler.FormularzDTO;

@Controller
@RequestMapping
public class Kontroler {
	
	@Autowired
	private kotDAO dao;
	

	
	@RequestMapping
	public String menu(Model model) {
		model.addAttribute("informacja", "Menu");
		return "menu";
	}
	
	@RequestMapping("/wszystkie")
	public String pokazWszystkie(Model model) {
		List<cat> koty = dao.pokazKoty();
		
		model.addAttribute("koty", koty);
		
		
		return "wszystkie";
	}
	
	@RequestMapping("/pokazkota/{id}")
	
	public String pokazKota(Model model, @PathVariable("id") Integer id ) {
		cat kotById = dao.pokazKotaById(id);
		model.addAttribute("kot", kotById);
		return "pokazkota";
	}
	
	@RequestMapping(value="/dodaj", method=RequestMethod.GET)
	public String formularz(Model model) {
		model.addAttribute("form", new FormularzDTO());
		return "formularz";
	}
	
	@RequestMapping(value="/dodaj", method=RequestMethod.POST)
	public String obsluzFormularz(@ModelAttribute("form") @Valid FormularzDTO form, BindingResult result ) {
		
		cat kot = new cat();
		kot.setName(form.getName());
		kot.setWeight(form.getWeight());
		kot.setGuardian(form.getNameOfGuardian());
		//java.sql.Date sDate = new java.sql.Date(form.getDateOfBirth());
		kot.setDateOfBirth(form.getDateOfBirth());
		//dao.dodajKota(kot);
		
		if(result.hasErrors()) {
		return "formularz";
		} else {
			dao.dodajKota(kot);
			return "redirect:/poFormularzu";
		}
	}
	
	@RequestMapping("/poFormularzu")
	public String poFormularzu(Model model) {
		
		model.addAttribute("informacja", "form jest ok");
		return "poFormularzu";
	}
	
	
}
	
	
	


