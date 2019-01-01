package pl.schronisko.kontroler;

//import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import pl.schronisko.application.interfejs;


public class FormularzDTO {
	
	@NotEmpty (message = "Imię nie może być puste.")
	@Size(min=3, message = "Min. 3 znaki.")
	private String name;
	
	@Past (message="Only the past is valid")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateOfBirth;
   
	
	@NotNull
	@Positive (message = "Waga musi być większa od 0.")
	private double weight; 
	
	@NotEmpty (message = "Imię opiekuna nie może być puste.")
	@Size(min=3, message = "Min. 3 znaki.")
	private String nameOfGuardian; 
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	} 
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getNameOfGuardian() {
		return nameOfGuardian;
	}
	public void setNameOfGuardian(String nameOfGuardian) {
		this.nameOfGuardian = nameOfGuardian;
	} 
	

	
	
}
