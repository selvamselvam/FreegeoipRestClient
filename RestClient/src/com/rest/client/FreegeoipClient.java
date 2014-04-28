package com.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class FreegeoipClient {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();
		System.setProperty("http.proxyHost", "xxxxxx.com");
		System.setProperty("http.proxyPort", "8080");
		String res = client.target("http://freegeoip.net/xml/google.com")
				.request("text/xml").get(String.class);
		System.out.println("Response:" + res);

	}
}
