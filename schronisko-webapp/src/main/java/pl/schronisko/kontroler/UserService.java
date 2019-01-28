package pl.schronisko.kontroler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.schronisko.application.UserRepository;
import pl.schronisko.domain.User;

@Service
public class UserService {

	
	@Autowired
	protected UserRepository userDao;
	
	public void saveUser(FormularzDTOUser formUser) {
		User user = new User();
		user.setUserName(formUser.getUserName());
		user.setPassword("{noop}"+formUser.getPassword());
		user.setRole("ROLE_USER");
		user.setEnabled(1);
		
		userDao.save(user);
	}
}
