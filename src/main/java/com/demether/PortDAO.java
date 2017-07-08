package com.demether;

import java.util.Arrays;
import java.util.List;

import com.demether.builder.PortBuilder;

public class PortDAO {
	public List<Port> list() {
		new PortBuilder().port("Santos");
		
		
		
		return Arrays.asList(buildPort("Santos", "Santos", "Brasil", "Mercosul", "América do Sul"),
				buildPort("Hamburg", "Hamburg", "Germany", "Euro", "Europe"));
	}

	public Port buildPort(String arg1, String arg2, String arg3, String arg4, String arg5) {
		return new Port(arg1, new City(arg2, new Country(arg3, new Trade(arg4, new Region(arg5)))));
	}
}
