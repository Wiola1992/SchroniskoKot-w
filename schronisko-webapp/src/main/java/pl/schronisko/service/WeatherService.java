package pl.schronisko.service;

import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.schronisko.pogoda.Lista;

@Service
public class WeatherService {

	final String appId="";
	final String adress ="http://api.openweathermap.org/data/2.5/forecast?q=";
	 String cityName;
	
	//final String language = "pl";
	
	public String pokazPogodeUrl(String cityName) throws MalformedURLException {
		String APIKEY="93dafa8d68c3a19abb656e62222388cb";
		String url = adress +cityName +"&APPID="+APIKEY+"&units=metric"+"&lang=pl";
		
		return url;
	}
	
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	/*public LocalDateTime toLocalDateTime (String date) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime localDate = LocalDateTime.parse(date, formatter);
		return localDate;
	}*/
	
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
		
		//	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		//	LocalDateTime localDateT = LocalDateTime.parse(data, formatter);
			
			listaWewnetrzna.setLocalDateTime(data);
			LocalDateTime localDateTime = listaWewnetrzna.getLocalDateTime();
			listaWewnetrzna.setLocalDate(service.toLocalDate(localDateTime));
			listaWewnetrzna.setHour(service.toHour(localDateTime));
			listaWewnetrzna.setDayOfWeek(localDateTime.getDayOfWeek());
			
		}
		
		return listaList;
	}
}
