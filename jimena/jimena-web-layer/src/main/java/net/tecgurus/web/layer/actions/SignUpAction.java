package net.tecgurus.web.layer.actions;

import java.util.ArrayList;
import java.util.List;

import net.tecgurus.business.layer.SignUpProcessor;
import net.tecgurus.business.layer.exceptions.BusinessException;
import net.tecgurus.business.layer.exceptions.ConfirmPassNotMatchException;
import net.tecgurus.business.layer.exceptions.EmailAlreadyRegisteredException;
import net.tecgurus.data.layer.exceptions.ServiceUnavailableException;
import net.tecgurus.web.layer.models.CountryModel;
import net.tecgurus.web.layer.models.SignUpModel;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/user")
@ParentPackage("struts-default")
public class SignUpAction 
	extends ActionSupport 
	implements ModelDriven<SignUpModel> {
	private static final String REDIRECT_HELLO_WORLD = "redirectHelloWorld";

	public static final String SIGN_UP = "signUp";

	public static final String REDIRECT_TO_SIGN_IN = "redirectToSignIn";

	private static final String SIGN_UP_JSP = "/WEB-INF/jsp/user/signUp.jsp";

	private static final long serialVersionUID = 1L;
	
	private long _userId;
	
	private final SignUpModel _signUpModel;
	private final SignUpProcessor _signUpProcessor;
	
	private final List<CountryModel> _countries;
	
	public SignUpAction(
			SignUpProcessor signUpProcessor
	) {
		_signUpModel = new SignUpModel();	
		_countries = new ArrayList<CountryModel>();
		
		_signUpProcessor = signUpProcessor;
	}

	@Action(value = SIGN_UP, results = { 
			@Result(location = SIGN_UP_JSP)
	})
	public String getSignUp() {
		return SUCCESS;
	}
	
	@Action(value = "processSignUp", results = {
			@Result(
					name= REDIRECT_HELLO_WORLD, 
					type= "redirectAction", 
					location= HelloWorldAction.HELLOWORLD,
					params = {
							"namespace", HelloWorldAction.NAMESPACE,
							"userId", "%{userId}"
					}
			),
			@Result(name = INPUT, location = SIGN_UP_JSP)
	})
	public String processSignUp() throws ServiceUnavailableException{
		try {
			_userId = _signUpProcessor.perform(
					_signUpModel.getUserName(),
					_signUpModel.getUserEmail(), 
					_signUpModel.getUserPassword(), 
					_signUpModel.getUserConfirmPass()
			);
		} catch (EmailAlreadyRegisteredException e) {
			addFieldError("userEmail", "email already registered");
		} catch (ConfirmPassNotMatchException e) {
			addFieldError("userConfirmPass", "Confirm pass does not match");
		} catch (BusinessException e) {
			addActionError(e.getMessage());
		}
		
		return hasErrors() ? INPUT : REDIRECT_HELLO_WORLD;
	}

	@Override
	public SignUpModel getModel() {
		return _signUpModel;
	}	
	
	public long getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public List<CountryModel> getCountries() {
		return _countries;
	}
}
