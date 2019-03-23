package pl.schronisko.pogoda;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class Lista {

	@JsonProperty("dt_txt")
	String data;
	
	@JsonProperty("dt")
	String czas;
	
    @JsonProperty("wind")
	Wind winds;
	
	@JsonProperty("weather")
	List<Weather> weathers;
		
	@JsonProperty("main")
	MainProp mains;
	
	
    LocalDateTime localDateTime;
	
	LocalDate localDate;
	
	DayOfWeek dayOfWeek;
	
	
	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}


	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	
	public void setLocalDateTime(String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime localDateT = LocalDateTime.parse(data, formatter);
		this.localDateTime = localDateT ;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(LocalDateTime localDateT) { 
		DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
		this.dayOfWeek = dayOfWeek;
	}

	/*	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	
	*/
	

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCzas() {
		return czas;
	}

	public void setCzas(String czas) {
		this.czas = czas;
	}

	public Wind getWinds() {
		return winds;
	}

	public void setWinds(Wind winds) {
		this.winds = winds;
	}

	public List<Weather> getWeathers() {
		return weathers;
	}

	public void setWeathers(List<Weather> weathers) {
		this.weathers = weathers;
	}

	public MainProp getMains() {
		return mains;
	}

	public void setMains(MainProp mains) {
		this.mains = mains;
	}


}
