package pl.schronisko.kontroler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import pl.schronisko.application.CatRepository;
import pl.schronisko.domain.cat;

@RestController
@RequestMapping(value="/koty")
public class KotyRESTKontroler {

	
	@Autowired
	protected CatRepository catDAO;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public cat getKota(@PathVariable int id  ){
		cat kot = catDAO.findById(id);
		return kot;
	}
	
	@RequestMapping(value="koteczek/{id}", method=RequestMethod.GET)
	public cat getKoteczka(@PathVariable int id  ){
		//RestTemplate rest = new RestTemplate();
		//cat kot = rest.getForObject("http://localhost:8080/schronisko-webapp/koty/{id}", cat.class);
		cat kot = catDAO.findById(id);
		return new ResponseEntity<cat>(kot, new HttpHeaders(), HttpStatus.OK).getBody();
	}
	
/*	
	@RequestMapping(value="", method=RequestMethod.GET)
	public @ResponseBody List<cat> getKoty(){
	}
*/
}
		

