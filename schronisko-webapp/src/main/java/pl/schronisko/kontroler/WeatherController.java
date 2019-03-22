package pl.schronisko.kontroler;

import java.net.MalformedURLException;
//import java.net.URL;

import javax.validation.Valid;
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import pl.schronisko.pogoda.PogodaRest;
import pl.schronisko.service.WeatherService;

//@Controller
@RestController
@RequestMapping(value = "rest")
public class WeatherController {

	@Autowired
	WeatherService weatherService;

	@RequestMapping(value = "/pogoda", method = RequestMethod.GET)
	// @GetMapping
	@Secured({ "ROLE_ANONYMOUS"})
	public String formularzPogody(Model model) {
		model.addAttribute("formPogoda", new FormularzDTOPogoda());
		return "formularzPogoda";
	}

	@Secured({ "ROLE_ANONYMOUS"})
	@RequestMapping(value="/pogoda",  method=RequestMethod.POST,  produces= MediaType.APPLICATION_JSON_VALUE)
	//@PostMapping
	public String formularz (@ModelAttribute  @Valid FormularzDTOPogoda formPogoda, BindingResult result ) throws MalformedURLException  {
		if(result.hasErrors()) {
			return new ResponseEntity<String>("dupa", HttpStatus.CONFLICT).getBody();
		}/* else {
			String city = formPogoda.getCity();
			
			return new ResponseEntity<>(city, HttpStatus.OK);
		}*/
		
		else{
			RestTemplate restTemplate = new RestTemplate();
			final String uri = weatherService.pokazPogodeUrl(formPogoda.getCity());
		
		ResponseEntity<String> response = restTemplate.getForEntity(
				uri,
		        String.class, HttpStatus.OK);
		
		return  response.getBody();
		
		}
		
	}
	
	
	
	@RequestMapping(value="/weather/{cityName}",  method=RequestMethod.GET,  produces= MediaType.APPLICATION_JSON_VALUE)
	//@PostMapping
	public ResponseEntity<PogodaRest> formularzDUPA (@PathVariable String cityName ) throws MalformedURLException  {
		if(cityName=="bobrowniki") {
			return new ResponseEntity<PogodaRest>(HttpStatus.BAD_REQUEST);
		}/* else {
			String city = formPogoda.getCity();
			
			return new ResponseEntity<>(city, HttpStatus.OK);
		}*/
		
		else{
			RestTemplate restTemplate = new RestTemplate();
			final String uri = weatherService.pokazPogodeUrl(cityName);
		
		ResponseEntity<PogodaRest> response = restTemplate.getForEntity(
				uri,
				PogodaRest.class, HttpStatus.OK);
		
		return  response;
		
		}
		
	} 
	
	// zwraca json cały
	@Secured({ "ROLE_ANONYMOUS"})
	@RequestMapping(value="/{cityName}",  method=RequestMethod.GET,  produces= MediaType.APPLICATION_JSON_VALUE)
	//@PostMapping
	public ResponseEntity<String> spr (@PathVariable String cityName ) throws MalformedURLException  {
		if(cityName==null) {
			String dupa = "To chyba pomyłka?";
			return new ResponseEntity<String> (dupa, HttpStatus.OK);
		} else{
			RestTemplate restTemplate = new RestTemplate();
			final String uri = weatherService.pokazPogodeUrl(cityName);
		
		ResponseEntity<String> response = restTemplate.getForEntity(
				uri,
				String.class);
		
		System.out.println(response.hasBody());
		System.out.println(response.getBody());
		
		return  response;
		}
	}
	
	@Secured({ "ROLE_ANONYMOUS"})
	@RequestMapping(value="/milion/{cityName}",  method=RequestMethod.GET,  produces= MediaType.APPLICATION_JSON_VALUE)
	//@PostMapping
	public PogodaRest sprMilion (@PathVariable String cityName ) throws MalformedURLException  {
		if(cityName==null) {
			String dupa = "To chyba pomyłka?";
			return new ResponseEntity<PogodaRest> ( HttpStatus.OK).getBody();
		} else{
			RestTemplate restTemplate = new RestTemplate();
			final String uri = weatherService.pokazPogodeUrl(cityName);
		
			ResponseEntity<PogodaRest> response = restTemplate.getForEntity(
				uri,
				PogodaRest.class);
			PogodaRest pogoda = response.getBody();
			
			
			System.out.println(response.getBody());
			System.out.println(pogoda.getCity());
		
		return  pogoda;
		}
	}
	
	@Secured({ "ROLE_ANONYMOUS"})
	@RequestMapping(value="/milionII/{cityName}",  method=RequestMethod.GET,  produces= MediaType.APPLICATION_JSON_VALUE)
	//@PostMapping
	public ResponseEntity<PogodaRest> sprMilionii (@PathVariable String cityName ) throws MalformedURLException  {
		if(cityName==null) {
			String dupa = "To chyba pomyłka?";
			return new ResponseEntity<PogodaRest> ( HttpStatus.OK);
		} else{
			RestTemplate restTemplate = new RestTemplate();
			final String uri = weatherService.pokazPogodeUrl(cityName);
		
			ResponseEntity<PogodaRest> response = restTemplate.getForEntity(uri, PogodaRest.class);
		
		return  response;
		}
	}
	
	
}
