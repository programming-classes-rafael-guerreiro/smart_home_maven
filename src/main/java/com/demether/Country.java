package com.demether;

public class Country {
	private final String name;
	private final Trade trade;

	public Country(String name, Trade trade) {
		this.name = name;
		this.trade = trade;
	}

	public String getName() {
		return name;
	}

	public Trade getTrade() {
		return trade;
	}

	public String getTradeName() {
		if (trade == null)
			return "";

		return trade.getName();
	}

	public Region getRegion() {
		if (trade == null)
			return null;

		return trade.getRegion();
	}

	public String getRegionName() {
		if (trade == null)
			return "";

		return trade.getRegionName();
	}
}
