package pl.schronisko.kontroler;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import pl.schronisko.pogoda.Lista;
import pl.schronisko.pogoda.PogodaRest;
import pl.schronisko.pogoda.Weather;
import pl.schronisko.service.WeatherService;

@Controller
@RequestMapping(value = "pogoda")
public class PogodaKontroler {
	
	@Autowired
	WeatherService weatherService;

	//@Secured({ "ROLE_ANONYMOUS"})
	@RequestMapping(value = "/pokaz", method = RequestMethod.GET)
	public String formularzPogody(Model model) {
		model.addAttribute("formPogoda", new FormularzDTOPogoda());
		return "formularzPogoda";
	}
	
	//@Secured({ "ROLE_ANONYMOUS"})
	@RequestMapping(value = "/pokaz", method = RequestMethod.POST)
	public String formularzPogody (Model model, @ModelAttribute @Valid FormularzDTOPogoda formPogoda, BindingResult result) throws MalformedURLException {
		if(result.hasErrors()) {
			return "formularzPogoda";
		} else {
			String uri = weatherService.pokazPogodeUrl(formPogoda.getCity());
			RestTemplate rest = new RestTemplate();
			PogodaRest pogoda = rest.getForObject(uri, PogodaRest.class);
			
			
			
			List<Lista> list = pogoda.getLista();
			pogoda.setLista(weatherService.uzupelnijDate(list));
			List<Lista> listaUzupelniona = pogoda.getLista();
			model.addAttribute("pogoda", pogoda);
			model.addAttribute("dateList", listaUzupelniona);
		
			return "pogoda"; 
		}
	}
}
