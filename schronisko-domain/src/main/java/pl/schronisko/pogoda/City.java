package pl.schronisko.pogoda;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class City {
	
	
		@JsonProperty("name")
		String name;
		
	

		public City() {
			super();
		}

		@JsonProperty("country")
		String kraj;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getKraj() {
			return kraj;
		}

		public void setKraj(String kraj) {
			this.kraj = kraj;
		}
	
}
