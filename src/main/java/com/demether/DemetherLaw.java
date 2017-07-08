package com.demether;

import java.util.List;

import com.demether.builder.PortBuilder;
import com.demether.builder.PortBuilder.TradeBuilder;
import com.demether.builder.PortBuilderPobre;

public class DemetherLaw {
	public static void main(String[] args) {
		PortDAO dao = new PortDAO();
		List<Port> list = dao.list();

		for (Port port : list) {
			System.out.println(port.getName() + " - " + port.getTradeName() + " - " + port.getRegionName());
		}

		TradeBuilder tradeBuilder = new PortBuilder().port("Santos").city("Santos").country("Brasil");
		tradeBuilder.trade("Mercosul");

		Port port = new PortBuilderPobre()	.port("Santos")
											.city("Santos")
											.country("Brasil")
											.region("América do Sul")
											.build();
	}
}
