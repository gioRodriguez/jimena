package net.tecgurus.web.layer.actions;

import java.util.ArrayList;
import java.util.List;

import net.tecgurus.web.layer.models.CountryModel;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/json")
@ParentPackage("json-default")
public class CountriesJsonAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private List<CountryModel> _countries;
	
	public CountriesJsonAction() {
		_countries = new ArrayList<CountryModel>();
	}
	
	@Action(value = "countries", results = { @Result(type = "json") })
	public String countries(){
		_countries.add(new CountryModel(1, "USA"));
		_countries.add(new CountryModel(2, "México"));
		_countries.add(new CountryModel(3, "Canada"));
		return SUCCESS;
	}

	public List<CountryModel> getCountries() {
		return _countries;
	}

}










