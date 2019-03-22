package pl.schronisko.kontroler;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.schronisko.application.UserRepository;

@Controller
@RequestMapping
public class ControllerUser {
	
	@Autowired
	protected UserRepository userDao;
	
	@Autowired
	protected UserService userService;

	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String logowanie (Model model ) {
		model.addAttribute("formUser", new FormularzDTOUser());
		return "formularzUser";
		
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String obsluzFormUser(@ModelAttribute("formUser") @Valid FormularzDTOUser formUser, BindingResult result ) {
		
		if(result.hasErrors()) {
			return "formularzUser";
		} else {
			userService.saveUser(formUser);
			return "redirect:/wszystkie";
		}
	}
	
	
}
