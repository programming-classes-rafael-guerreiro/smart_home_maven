package com.demether;

public class City {
	private final String name;
	private final Country country;

	public City(String name, Country country) {
		this.name = name;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public Country getCountry() {
		return country;
	}

	public String getCountryName() {
		if (country == null)
			return "";

		return country.getName();
	}

	public Trade getTrade() {
		if (country == null)
			return null;

		return country.getTrade();
	}

	public String getTradeName() {
		if (country == null)
			return "";

		return country.getTradeName();
	}

	public Region getRegion() {
		if (country == null)
			return null;

		return country.getRegion();
	}

	public String getRegionName() {
		if (country == null)
			return "";

		return country.getRegionName();
	}
}
