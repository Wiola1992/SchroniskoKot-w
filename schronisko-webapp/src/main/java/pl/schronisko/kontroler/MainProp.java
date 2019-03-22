package pl.schronisko.kontroler;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MainProp {

	@JsonProperty("temp")
	String temp;
/*	@JsonProperty("temp_min")
	String temp_min;
	@JsonProperty("temp_max")
	String temp_max; */
}
