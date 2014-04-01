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
	private static final String SIGN_UP_JSP = "/WEB-INF/jsp/user/signUp.jsp";

	private static final long serialVersionUID = 1L;
	
	private SignUpModel _signUpModel;
	private SignUpProcessor _signUpProcessor;
	
	public SignUpAction() {
		_signUpModel = new SignUpModel();
		
		_signUpProcessor = new SignUpProcessor();
	}

	@Action(value = "signUp", results = { 
			@Result(location = SIGN_UP_JSP) })
	public String getSignUp() {
		return SUCCESS;
	}
	
	@Action(value = "processSignUp", results = {
			@Result(location = SIGN_UP_JSP),
			@Result(name="redirectToSignIn", type="redirect", location="signIn")
	})
	public String processSignUp(){
		boolean userRegistered = _signUpProcessor.perform(
				_signUpModel.getUserName(), 
				_signUpModel.getUserEmail(), 
				_signUpModel.getUserPassword(), 
				_signUpModel.getUserConfirmPass()
		);
		
		if(userRegistered){
			return "redirectToSignIn";
		}
				
		return SUCCESS;
	}

	@Override
	public SignUpModel getModel() {
		return _signUpModel;
	}
	
	
	
	
	
	
}
