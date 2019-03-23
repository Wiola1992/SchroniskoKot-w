package pl.schronisko.service;

import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import pl.schronisko.pogoda.Lista;

@Service
@PropertySource("classpath:prop.yml")
public class WeatherService {

	final String adress ="http://api.openweathermap.org/data/2.5/forecast?q=";
	 String cityName;
	
	//final String language = "pl";
	
	public String pokazPogodeUrl(String cityName) throws MalformedURLException {
		String url = adress +cityName +"&APPID="+ "${properties.ap.root}"+"&units=metric"+"&lang=pl";
		
		return url;
	}
	
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public int toHour (LocalDateTime localDateTime ) {
		int godzina =localDateTime.getHour();
		return godzina;
	}
	
	public LocalDate toLocalDate(LocalDateTime localDateTime) {
		LocalDate localDate = localDateTime.toLocalDate();
		return localDate;
	}
	
	public List<Lista> uzupelnijDate (List<Lista> listaList){
		
		for (int i=0; i<listaList.size(); i++) {
			WeatherService service = new WeatherService();
			Lista listaWewnetrzna = listaList.get(i);
			String data = listaWewnetrzna.getData();
					
			listaWewnetrzna.setLocalDateTime(data);
			LocalDateTime localDateTime = listaWewnetrzna.getLocalDateTime();
			listaWewnetrzna.setLocalDate(service.toLocalDate(localDateTime));
			listaWewnetrzna.setDayOfWeek(localDateTime);
			
		}
		
		return listaList;
	}
}
