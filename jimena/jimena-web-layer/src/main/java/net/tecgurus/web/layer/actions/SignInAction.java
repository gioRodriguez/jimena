package net.tecgurus.web.layer.actions;

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
	public static final String SIGN_IN = "signIn";

	private static final String SIGN_IN_JSP = "/WEB-INF/jsp/user/signIn.jsp";

	private static final long serialVersionUID = 1L;
	
	private final SignInModel _signInModel;

	public SignInAction() {
		_signInModel = new SignInModel();
	}
	
	@Action(value = SIGN_IN, results = {
			@Result(location = SIGN_IN_JSP)
	})
	public String getSignIn(){
		return SUCCESS;
	}
	
	@Action(value = "processSignIn", results = {
			@Result(location = SIGN_IN_JSP)
	})
	public String processSignIn(){
		return SUCCESS;
	}
	
	@Override
	public SignInModel getModel() {
		return _signInModel;
	}

}
