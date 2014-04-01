package net.tecgurus.web.layer.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/tecgurus")
@ParentPackage("struts-default")
public class HelloWorldAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Action(
			value = "helloworld"
			, results = {
					@Result(
							location = "/WEB-INF/jsp/helloworld.jsp"
					)
				}
	)
	public String execute(){
		return SUCCESS;
	}
}
