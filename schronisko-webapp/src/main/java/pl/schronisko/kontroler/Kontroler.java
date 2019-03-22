package pl.schronisko.kontroler;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.schronisko.application.CatRepository;
import pl.schronisko.domain.FileMetaData;
import pl.schronisko.domain.Toy;
import pl.schronisko.domain.cat;
import pl.schronisko.service.FileService;

@Controller
@RequestMapping
public class Kontroler {
	
	
	@Autowired
	protected CatRepository catDAO;
	
	@Autowired
	protected FileService fileService;
	
	@Autowired
	protected EmailService emailService;
	
	@Autowired
	protected ToyService toyService;
	
	@RequestMapping
	public String menu(Model model) {
		model.addAttribute("informacja", "Menu");
		return "menu";
	}
	
	@Secured({ "ROLE_USER"})
	@RequestMapping("/wszystkie")
	public String pokazWszystkie(Model model) {
	
		Iterable<cat> koty = catDAO.findAll();
		
		model.addAttribute("koty", koty);
		
		
		return "wszystkie";
	}
	
	@Secured({ "ROLE_USER"})
	@RequestMapping("/pokazkota/{id}")
	
	public String pokazKota(Model model, @PathVariable("id") Integer id ) {
		Optional<cat> opt = catDAO.findById(id);
		//cat kot = catDAO.findById(id);
		cat kot = new cat();
		if(opt!=null) {
			kot = opt.get();
		}
		
		List<Toy> zabawki =toyService.findAllToyByCat(kot);
		model.addAttribute("kotById", kot);
		model.addAttribute("zabawki", zabawki);
		model.addAttribute("id", id);
		
		List<FileMetaData> files = fileService.FindAllFiles(id);
		model.addAttribute("files", files);
		return "pokazkota";
	}
	
	
	@Secured({ "ROLE_USER"})
	@RequestMapping(value="/dodaj", method=RequestMethod.GET)
	public String formularz(Model model) {
		model.addAttribute("form", new FormularzDTO());
		return "formularz";
	}
	
	@Secured({ "ROLE_USER"})
	@RequestMapping(value="/dodaj", method=RequestMethod.POST)
	public String obsluzFormularz(@ModelAttribute("form") @Valid FormularzDTO form, BindingResult result ) {
		
		cat kot = new cat();
		kot.setName(form.getName());
		kot.setWeight(form.getWeight());
		kot.setGuardian(form.getNameOfGuardian());
		if(form.getDateOfBirth()!=null) {
			//java.sql.Date sDate = new java.sql.Date(form.getDateOfBirth().getTime());
			//kot.setDateOfBirth(sDate);
			kot.setDateOfBirth(form.getDateOfBirth());
		}
		
		if(result.hasErrors()) {
		return "formularz";
		} else {
			catDAO.save(kot);
			
			return "redirect:/poFormularzu";
		}
	}
	
	@RequestMapping("/poFormularzu")
	public String poFormularzu(Model model) {
		
		model.addAttribute("informacja", "Formularz wysłano prawidłowo.");
		return "poFormularzu";
	}
	
	
	
	@RequestMapping(value="/kontakt", method=RequestMethod.GET)
	public String formularzKontaktowy (Model model) {
		model.addAttribute("formKontakt", new FormularzDTOKontakt());
		return "formularzKontaktowy";
	}
	
	@RequestMapping(value="/kontakt", method=RequestMethod.POST)
	public String obsluzFormularzKontaktowy(@ModelAttribute("formKontakt") @Valid FormularzDTOKontakt formKontakt, BindingResult result ) {
		Boolean spr =emailService.sendEmail("wiolamm2@gmail.com", formKontakt.getSubject(), formKontakt.getMessage());
		if(result.hasErrors() || !spr) {
		return "formularzKontaktowy";
		} else {
			return "redirect:/poFormularzuKontaktowym";
		}
	}
	
	@RequestMapping("/poFormularzuKontaktowym")
	public String poFormularzuKontaktowym(Model model) {
		
		model.addAttribute("informacja", "Wiadomość wysłana prawidłowo. Skontaktujemy się z Państwem w ciągu 48h.");
		return "poFormularzu";
	}
	
	
}
	
	
	


