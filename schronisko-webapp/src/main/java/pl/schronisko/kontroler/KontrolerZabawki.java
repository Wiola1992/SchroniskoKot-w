package pl.schronisko.kontroler;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class KontrolerZabawki {
	
	@Autowired
	ToyService toyService;
	
	@RequestMapping(value="/kot/{idK}/zabawka/add", method=RequestMethod.GET)
	public String dodawanieZabawki (Model model, @PathVariable("idK") Integer id) {
		model.addAttribute("ToyAdd", new FormularzZabawka());
		return "zabawkaAdd";
	}
	
	@RequestMapping(value="/kot/{idK}/zabawka/add", method=RequestMethod.POST)
	public String obsluzFormularzZabawki(@ModelAttribute("ToyAdd") @Valid FormularzZabawka ToyAdd, BindingResult result, @PathVariable("idK") Integer id, Model model ) {
		model.addAttribute("id", id);
		if(result.hasErrors()) {
		return "zabawkaAdd";
		} else {
			toyService.saveToy(ToyAdd, id);
			}
			return "redirect:../../../pokazkota/{id}";
		
	}

	
	@RequestMapping(value="/kot/{id}/zabawka/{idToys}/remove")
	public String usunZabawke(Model model, @PathVariable("id") Integer id,  @PathVariable("idToys") Integer idToys){
		model.addAttribute("id", id);
		toyService.deleteToyById(idToys);
		
		return "zabawkaRemove";
	}
	

}
