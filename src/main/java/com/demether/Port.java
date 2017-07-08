package com.demether;

public class Port {
	private final String name;
	private final City city;

	public Port(String name, City city) {
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public City getCity() {
		return city;
	}

	public String getCityName() {
		if (city == null)
			return "";

		return city.getName();
	}

	public Country getCountry() {
		if (city == null)
			return null;

		return city.getCountry();
	}

	public String getCountryName() {
		if (city == null)
			return "";

		return city.getName();
	}

	public Trade getTrade() {
		if (city == null)
			return null;

		return city.getTrade();
	}

	public String getTradeName() {
		if (city == null)
			return "";

		return city.getTradeName();
	}

	public Region getRegion() {
		if (city == null)
			return null;

		return city.getRegion();
	}

	public String getRegionName() {
		if (city == null)
			return "";

		return city.getRegionName();
	}
}
