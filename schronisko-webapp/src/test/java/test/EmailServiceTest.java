package test;

//import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
//import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;
import pl.schronisko.kontroler.EmailService;


@RunWith(MockitoJUnitRunner.class)
public class EmailServiceTest  {


	
	//String message = "wiadomość wysłana";
	String recipientEmail = "wioletta.barwacz@gmail.com";
	String subject = "testowanie";
	String content = "próba testowania";
	
	@Test
	public void testSendEmail1() {
	
		EmailService mail = new EmailService();
		Assert.assertTrue(mail.sendEmail(recipientEmail, subject, content));
	
	}
	
	/*public String testSendEmail2() {
		EmailService mail = new EmailService();
		String recipientEmail = "wioletta.barwacz@gmail.com";
		String subject = "testowanie";
		String content = "próba testowania";
		
	//	Mockito.when(mail.sendEmail(Matchers.eq("wioletta.barwacz@gmail.com"), Matchers.anyString(), Matchers.anyString())).thenAnswer(message);
	}*/
}
