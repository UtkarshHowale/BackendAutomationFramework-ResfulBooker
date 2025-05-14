package com.api.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.models.requests.TokenRequest;
import com.api.models.response.TokenResponse;
import com.api.services.AuthService;
import com.api.services.BookingService;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class DeleteBooking_API {

	@Test
	public void testDeleteBookingAPI() {

		TokenRequest tokenRequest = new TokenRequest("admin", "password123");
		AuthService authService = new AuthService();
		Response response = authService.createToken(tokenRequest);
		TokenResponse tokenResponse = response.as(TokenResponse.class);

		BookingService deletebookingService = new BookingService();
		response = deletebookingService.deleteBooking(tokenResponse.getToken(), 1620);
		System.out.println(response.asPrettyString());
	}
}
