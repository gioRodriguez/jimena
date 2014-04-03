package net.tecgurus.web.layer.actions;

import net.tecgurus.business.layer.SignUpProcessor;
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
	public static final String SIGN_UP = "signUp";

	private static final String REDIRECT_TO_SIGN_IN = "redirectToSignIn";

	private static final String SIGN_UP_JSP = "/WEB-INF/jsp/user/signUp.jsp";

	private static final long serialVersionUID = 1L;
	
	private SignUpModel _signUpModel;
	private SignUpProcessor _signUpProcessor;
	
	public SignUpAction() {
		_signUpModel = new SignUpModel();
		
		_signUpProcessor = new SignUpProcessor();
	}

	@Action(value = SIGN_UP, results = { 
			@Result(location = SIGN_UP_JSP) })
	public String getSignUp() {
		return SUCCESS;
	}
	
	@Action(value = "processSignUp", results = {
			@Result(location = SIGN_UP_JSP),
			@Result(
					name= REDIRECT_TO_SIGN_IN, 
					type= "redirect", 
					location= SignInAction.SIGN_IN
			)
	})
	public String processSignUp(){
		boolean userRegistered = _signUpProcessor.perform(
				_signUpModel.getUserName(), 
				_signUpModel.getUserEmail(), 
				_signUpModel.getUserPassword(), 
				_signUpModel.getUserConfirmPass()
		);
		
		if(userRegistered){
			return REDIRECT_TO_SIGN_IN;
		}
				
		return SUCCESS;
	}

	@Override
	public SignUpModel getModel() {
		return _signUpModel;
	}
	
	
	public int getId(){
		return 3;
	}
	
	
	
}
