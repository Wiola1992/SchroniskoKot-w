package pl.schronisko.kontroler;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class FormularzZabawka {

	@NotEmpty(message="Podaj nazwę zabawki")
	@Size(min=3, message = "Min. 3 znaki.")
	String nameToy;
	
	@NotEmpty(message="Podaj opis zabawki")
	@Size(min=3, message = "Min. 3 znaki.")
	String description;
	
	public String getNameToy() {
		return nameToy;
	}

	public void setNameToy(String name) {
		this.nameToy = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
