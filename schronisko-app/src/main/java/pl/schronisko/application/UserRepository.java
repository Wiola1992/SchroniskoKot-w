package pl.schronisko.application;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.schronisko.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}
