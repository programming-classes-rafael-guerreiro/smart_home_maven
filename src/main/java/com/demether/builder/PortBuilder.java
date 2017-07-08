package com.demether.builder;

import com.demether.City;
import com.demether.Country;
import com.demether.Port;
import com.demether.Region;
import com.demether.Trade;

public class PortBuilder {
	// Mutable
	// Breaks Law of Demether

	public PortBuilder() {
	}

	public CityBuilder port(String port) {
		return new CityBuilder(port);
	}

	public static class CityBuilder {
		private final String port;

		private CityBuilder(String port) {
			this.port = port;
		}

		public CountryBuilder city(String city) {
			return new CountryBuilder(port, city);
		}
	}

	public static class CountryBuilder {
		private final String port;
		private final String city;

		private CountryBuilder(String port, String city) {
			this.port = port;
			this.city = city;
		}

		public TradeBuilder country(String country) {
			return new TradeBuilder(port, city, country);
		}
	}

	public static class TradeBuilder {
		private final String port;
		private final String city;
		private final String country;

		private TradeBuilder(String port, String city, String country) {
			this.port = port;
			this.city = city;
			this.country = country;
		}

		public RegionBuilder trade(String trade) {
			return new RegionBuilder(port, city, country, trade);
		}
	}

	public static class RegionBuilder {
		private final String port;
		private final String city;
		private final String country;
		private final String trade;

		private RegionBuilder(String port, String city, String country, String trade) {
			this.port = port;
			this.city = city;
			this.country = country;
			this.trade = trade;
		}

		public Port region(String name) {
			Region region = new Region(name);
			Trade trade = new Trade(this.trade, region);
			Country country = new Country(this.country, trade);
			City city = new City(this.city, country);
			return new Port(this.port, city);
		}
	}
}
