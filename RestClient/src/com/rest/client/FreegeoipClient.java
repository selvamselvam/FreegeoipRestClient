package com.rest.client;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class FreegeoipClient {

	public static String URL = "http://freegeoip.net/xml/";

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("google.com");
		list.add("yahoo.com");
		list.add("hp.com");

		Client client = ClientBuilder.newClient();
		System.setProperty("http.proxyHost", "xxxxx.com");
		System.setProperty("http.proxyPort", "8080");

		for (String str : list) {
			String res = client.target(URL + str).request("text/xml")
					.get(String.class);
			System.out.println("Response:" + res);
		}

	}
}
