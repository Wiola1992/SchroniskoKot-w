package pl.schronisko.kontroler;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class FormularzDTOPogoda {

	@NotEmpty(message="Podaj lokalizację. To pole nie może pozostać puste.")
	@Size(min=3)
	String city;

	public FormularzDTOPogoda() {
		super();
	}

	public FormularzDTOPogoda(@NotEmpty(message = "Podaj lokalizację") @Size(min = 3) String city) {
		super();
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
