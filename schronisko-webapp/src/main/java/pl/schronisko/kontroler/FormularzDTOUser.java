package pl.schronisko.kontroler;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class FormularzDTOUser {

	
	@NotEmpty (message = "Podaj nazwę użytkownika")
	@Size(min=3, message = "Min. 3 znaki.")
	String userName;
	
	@NotEmpty (message = "Podaj hasło")
	@Size(min=3, message = "Min. 8 znaków.")
	String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
