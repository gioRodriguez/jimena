package net.tecgurus.web.layer.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(HelloWorldAction.NAMESPACE)
@ParentPackage("struts-default")
public class HelloWorldAction extends ActionSupport {
	public static final String HELLOWORLD = "helloworld";
	public static final String NAMESPACE = "/tecgurus";
	
	private static final long serialVersionUID = 1L;
	
	private int _userId;

	@Action(
			value = HELLOWORLD
			, results = {
					@Result(
							location = "/WEB-INF/jsp/helloworld.jsp"
					)
				}
	)
	public String execute(){
		return SUCCESS;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}
}
