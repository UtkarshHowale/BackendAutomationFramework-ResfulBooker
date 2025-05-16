package com.api.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.models.requests.TokenRequest;
import com.api.models.response.TokenResponse;
import com.api.services.AuthService;

import io.restassured.response.Response;

@Listeners(com.api.filters.TestListener.class)
public class CreateToken_API {

	@Test(description = "Verify create token API is working fine.")
	public void testCreateTokenAPI() {

		TokenRequest tokenRequest = new TokenRequest("admin", "password123");
		AuthService authService = new AuthService();
		Response response = authService.createToken(tokenRequest);

		TokenResponse tokenResponse = response.as(TokenResponse.class);

		System.out.println(response.asPrettyString());
		System.out.println(tokenResponse.getToken());

		assertEquals(response.statusCode(), 500);
		assertTrue(tokenResponse.getToken() != null);

	}
}
