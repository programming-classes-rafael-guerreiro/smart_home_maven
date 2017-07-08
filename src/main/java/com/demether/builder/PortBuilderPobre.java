package com.demether.builder;

import com.demether.City;
import com.demether.Country;
import com.demether.Port;
import com.demether.Region;
import com.demether.Trade;

public class PortBuilderPobre {
	// Mutable
	// Breaks Law of Demether

	private String port;
	private String city;
	private String country;
	private String trade;
	private String region;

	public PortBuilderPobre() {
	}

	public PortBuilderPobre port(String port) {
		this.port = port;
		return this;
	}

	public PortBuilderPobre city(String city) {
		this.city = city;
		return this;
	}

	public PortBuilderPobre country(String country) {
		this.country = country;
		return this;
	}

	public PortBuilderPobre trade(String trade) {
		this.trade = trade;
		return this;
	}

	public PortBuilderPobre region(String region) {
		this.region = region;
		return this;
	}

	public Port build() {
		Region region = new Region(this.region);
		Trade trade = new Trade(this.trade, region);
		Country country = new Country(this.country, trade);
		City city = new City(this.city, country);
		return new Port(this.port, city);
	}
}
