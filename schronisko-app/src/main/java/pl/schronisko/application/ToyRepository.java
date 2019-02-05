package pl.schronisko.application;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.schronisko.domain.Toy;
import pl.schronisko.domain.cat;

@Repository
public interface ToyRepository extends CrudRepository<Toy, Integer> {

	public List<Toy> findByOwner(cat cat);
	
	
	public Toy findByIdToys(int id);
	
	
	
	
	
}
 