package pl.schronisko.kontroler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.schronisko.application.CatRepository;
import pl.schronisko.application.ToyRepository;
import pl.schronisko.domain.Toy;
import pl.schronisko.domain.cat;

@Service
public class ToyService {
	
	@Autowired
	protected ToyRepository toyDAO;
	
	@Autowired
	protected CatRepository catDAO;
	
	

	public ToyService() {
		super();
	}

	public void saveToy(FormularzZabawka formZabawka, int id) {
		Toy zabawka = new Toy();
		zabawka.setName(formZabawka.getNameToy());
		zabawka.setDescription(formZabawka.getDescription());
		
		cat kotek = catDAO.findById(id);
	/*	Optional<cat> opt =catDAO.findById(id);
		cat kot = new cat();
		if(opt!=null) {
			kotek = opt.get();
		} */
		zabawka.setOwner(kotek);
		
		toyDAO.save(zabawka);
		
	}
	
	public List<Toy> findAllToyByCat(cat cat){
		
		
			List<Toy> toys = toyDAO.findByOwner(cat);
			return toys;
	} 
	
	public Toy findToyByIdToys(int id) {
		//Optional<Toy> toy = toyDAO.findById(id);
		Toy toy = toyDAO.findByIdToys(id);
		return toy;
	}
	
	public void deleteToyById(int id) {
		toyDAO.deleteById(id);
	}
}
