package net.tecgurus.web.layer.actions;

import net.tecgurus.business.layer.SignInProcessor;
import net.tecgurus.data.layer.exceptions.ServiceUnavailableException;
import net.tecgurus.web.layer.models.SignInModel;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/user")
@ParentPackage("struts-default")
public class SignInAction 
	extends ActionSupport
	implements ModelDriven<SignInModel>{
	private static final String REDIRECT_TO_SIGN_UP = "redirectToSignUp";

	public static final String SIGN_IN = "signIn";

	private static final String SIGN_IN_JSP = "/WEB-INF/jsp/user/signIn.jsp";

	private static final long serialVersionUID = 1L;
	
	private final SignInModel _signInModel;	
	private final SignInProcessor _signInProcessor;

	public SignInAction(
			SignInProcessor signInProcessor
	) {
		_signInModel = new SignInModel();
		
		_signInProcessor = signInProcessor;
	}
	
	@Action(value = SIGN_IN, results = {
			@Result(location = SIGN_IN_JSP)
	})
	public String getSignIn(){
		return SUCCESS;
	}
	
	@Action(value = "processSignIn", results = {
			@Result(location = SIGN_IN_JSP),
			@Result(
					name = REDIRECT_TO_SIGN_UP, 
					type = "redirect", 
					location = SignUpAction.SIGN_UP),
			@Result( name = INPUT, location = SIGN_IN_JSP)
	})
	public String processSignIn() throws ServiceUnavailableException{
		boolean isValidUser = _signInProcessor.perform(
				_signInModel.getUserEmail(), 
				_signInModel.getUserPassword()
		);
		
		if(isValidUser){
			return REDIRECT_TO_SIGN_UP;
		}
		
		return SUCCESS;
	}
	
	@Override
	public SignInModel getModel() {
		return _signInModel;
	}

}
