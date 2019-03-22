package pl.schronisko.pogoda;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PogodaRest {

	@JsonProperty("city")
	City city;
	
	@JsonProperty("list")
	private List<Lista> lista;
	
	
	public City getCity() {
		return city;
	}


	public void setCity(City city) {
		this.city = city;
	}


	public List<Lista> getLista() {
		return lista;
	}


	public void setLista(List<Lista> lista) {
		this.lista = lista;
	}


		
	

}
