package com.api.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.models.requests.BookingRequest;
import com.api.models.requests.TokenRequest;
import com.api.models.response.BookingResponse;
import com.api.models.response.TokenResponse;
import com.api.services.AuthService;
import com.api.services.BookingService;

import io.restassured.response.Response;

@Listeners(com.api.filters.TestListener.class)
public class CRUD_Flow_Automation {

	@Test
	public void testEndToEnd_CRUD_Flow() {

		// genrate token
		TokenRequest tokenRequest = new TokenRequest("admin", "password123");
		AuthService authService = new AuthService();
		Response response = authService.createToken(tokenRequest);
		System.out.println(response.asPrettyString());

		TokenResponse tokenResponse = response.as(TokenResponse.class);
		System.out.println(tokenResponse.getToken());

		System.out.println("=============================================");

		// Create booking
		BookingRequest createBookingRequest = new BookingRequest.Builder().firstName("Utkarsh").lastName("Test User")
				.totalPrice(5000).additionalNeeds("Food").depositePaid(true).bookingDates("2025-05-10", "2025-05-12")
				.Build();
		BookingService createbookingService = new BookingService();
		response = createbookingService.createBooking(createBookingRequest);
		System.out.println(response.asPrettyString());
		BookingResponse bookingResponse = response.as(BookingResponse.class);
		System.out.println(bookingResponse.getBookingid());

		System.out.println("=============================================");

		// Get booking
		BookingService bookingService = new BookingService();
		response = bookingService.getBooking(bookingResponse.getBookingid());
		System.out.println(response.asPrettyString());

		System.out.println("=============================================");

		// update booking
		BookingRequest updateBookingRequest = new BookingRequest.Builder().firstName("Sarvesh").lastName("Test User")
				.totalPrice(10000).additionalNeeds("Game").depositePaid(true).bookingDates("2025-05-12", "2025-05-14")
				.Build();

		BookingService updatebookingService = new BookingService();
		response = updatebookingService.updateBooking(tokenResponse.getToken(), updateBookingRequest,
				bookingResponse.getBookingid());
		System.out.println(response.asPrettyString());

		System.out.println("=============================================");

		// delete booking
		BookingService deletebookingService = new BookingService();
		response = deletebookingService.deleteBooking(tokenResponse.getToken(), bookingResponse.getBookingid());
		System.out.println(response.asPrettyString());

		System.out.println("=============================================");
	}
}
