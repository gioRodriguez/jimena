package net.tecgurus.web.layer.models;

import java.io.Serializable;

public class CountryModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private final int _countryId;
	private final String _countryName;
	
	public CountryModel(int countryId, String countryName) {
		_countryId = countryId;
		_countryName = countryName;
	}

	public int getCountryId() {
		return _countryId;
	}

	public String getCountryName() {
		return _countryName;
	}

}
