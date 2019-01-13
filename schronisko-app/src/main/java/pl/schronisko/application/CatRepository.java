package pl.schronisko.application;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import pl.schronisko.domain.cat;

public interface CatRepository extends CrudRepository<cat, Integer> {
	
	//public cat findById(int id); 
	
	//public List<cat> findAll();
	
	
}
