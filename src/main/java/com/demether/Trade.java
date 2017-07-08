package com.demether;

public class Trade {
	private final String name;
	private final Region region;

	public Trade(String name, Region region) {
		this.name = name;
		this.region = region;
	}

	public String getName() {
		return name;
	}

	public Region getRegion() {
		return region;
	}

	public String getRegionName() {
		if (region == null)
			return "";

		return region.getName();
	}
}
