package pl.schronisko.application;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.schronisko.domain.cat;

@Repository
public interface CatRepository extends CrudRepository<cat, Integer> {
	
	
	
}