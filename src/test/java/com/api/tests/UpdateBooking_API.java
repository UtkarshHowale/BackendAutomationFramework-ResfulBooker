package com.api.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.models.requests.BookingRequest;
import com.api.models.requests.TokenRequest;
import com.api.models.response.TokenResponse;
import com.api.services.AuthService;
import com.api.services.BookingService;

import io.restassured.response.Response;

@Listeners(com.api.filters.TestListener.class)
public class UpdateBooking_API {

	@Test
	public void testUpdateBookingAPI() {
		
		TokenRequest tokenRequest = new TokenRequest("admin", "password123");
		AuthService authService = new AuthService();
		Response response = authService.createToken(tokenRequest);
		TokenResponse tokenResponse = response.as(TokenResponse.class);

		BookingRequest updateBookingRequest = new BookingRequest.Builder().firstName("Sarvesh").lastName("Test User")
				.totalPrice(10000).additionalNeeds("Game").depositePaid(true).bookingDates("2025-05-12", "2025-05-14")
				.Build();

		BookingService bookingService = new BookingService();
		response = bookingService.updateBooking(tokenResponse.getToken(), updateBookingRequest, 1620);
		System.out.println(response.asPrettyString());
	}
}
