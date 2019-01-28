package test;

import junit.framework.Assert;
import junit.framework.TestCase;
import pl.schronisko.kontroler.EmailService;

public class TestEmailService extends TestCase {

	public void testSendEmail1() {
		EmailService mail = new EmailService();
		String recipientEmail = "wioletta.barwacz@gmail.com";
		String subject = "testowanie";
		String content = "próba testowania";
		Assert.assertTrue(mail.sendEmail(recipientEmail, subject, content));
		//Assert.assertFalse("dupa", mail.sendEmail(recipientEmail, subject, content));
	}
	
	/*public void testSendEmail2() {
		EmailService mail = new EmailService();
		String recipientEmail = "wioletta.barwacz@gmail.com";
		String subject = "testowanie";
		String content = "próba testowania";
		//Assert.assertTrue(mail.sendEmail(recipientEmail, subject, content));
		Assert.assertFalse("dupa", mail.sendEmail(recipientEmail, subject, content));
	}*/
}
