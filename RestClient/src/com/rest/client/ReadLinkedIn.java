package com.rest.client;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.LinkedInApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

public class ReadLinkedIn {
	public static void main(String[] args) {

		System.setProperty("http.proxyHost", "xxxx.com");
		System.setProperty("http.proxyPort", "8080");

		OAuthService service = new ServiceBuilder().provider(LinkedInApi.class)
				.apiKey("API Key").apiSecret("Secret Key").build();

		// Assume you already obtained an access token and imported the
		// appropriate classes
		System.out.println("********A basic user profile call********");

		// String url = "http://api.linkedin.com/v1/people/~";
		String url = "http://api.linkedin.com/v1/people/~/suggestions/job-suggestions";
		OAuthRequest request = new OAuthRequest(Verb.GET, url);

		// sign the request with my access token
		service.signRequest(new Token("OAuth User Token", "OAuth User Secret"),
				request);

		// send the request and get the response
		org.scribe.model.Response response = request.send();

		// print out the response body
		System.out.println(response.getBody());

	}
}
