package net.tecgurus.web.layer.actions;

import static org.junit.Assert.assertEquals;
import net.tecgurus.business.layer.SignUpProcessor;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class SignUpActionTest {

	@Test
	public void processSignUpTest() {
		// arrange
		String expected = SignUpAction.REDIRECT_TO_SIGN_IN;
		
		SignUpProcessor signUpProcessor = new MockSignUpProcessor();
		SignUpAction signUpAction = new SignUpAction(signUpProcessor);
		
		// act
		String actual = signUpAction.processSignUp();
		
		// assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void processSignUpWhitRegisterFailTest() {
		// arrange
		String expected = SignUpAction.SUCCESS;
		
		SignUpProcessor signUpProcessor = Mockito.mock(SignUpProcessor.class);
		ArgumentCaptor<String> userNameCaptor = ArgumentCaptor.forClass(String.class);
		ArgumentCaptor<String> userEmailCaptor = ArgumentCaptor.forClass(String.class);
		ArgumentCaptor<String> userPasswordCaptor = ArgumentCaptor.forClass(String.class);
		ArgumentCaptor<String> userConfirmPassCaptor = ArgumentCaptor.forClass(String.class);
		Mockito.when(signUpProcessor.perform(
				userNameCaptor.capture(), 
				userEmailCaptor.capture(), 
				userPasswordCaptor.capture(), 
				userConfirmPassCaptor.capture()))
				.thenReturn(false);
		
		SignUpAction signUpAction = new SignUpAction(signUpProcessor);
		
		signUpAction.getModel().setUserName("gio");
		signUpAction.getModel().setUserEmail("mail@mail.com");
		signUpAction.getModel().setUserPassword("123");
		signUpAction.getModel().setUserConfirmPass("123");
		
		// act
		String actual = signUpAction.processSignUp();
		
		// assert
		assertEquals(expected, actual);
		assertEquals("gio", userNameCaptor.getValue());
		assertEquals("mail@mail.com", userEmailCaptor.getValue());
		assertEquals("123", userPasswordCaptor.getValue());
		assertEquals("123", userConfirmPassCaptor.getValue());
	}

	
	
	
	
}
