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


public class FormularzDTOKontakt {
	
	@NotEmpty (message = "Podaj temat wiadomości.")
	@Size(min=3, message = "Min. 3 znaki.")
	private String subject;

	@NotEmpty (message = "Wiadomość nie może być pusta.")
	@Size(min=3, message = "Min. 3 znaki.")
	private String message;

	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
