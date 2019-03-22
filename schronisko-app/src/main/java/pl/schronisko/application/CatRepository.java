package pl.schronisko.application;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.schronisko.domain.cat;

@Repository
public interface CatRepository extends CrudRepository<cat, Integer> {
	
	
	public cat findById(int id);
}
