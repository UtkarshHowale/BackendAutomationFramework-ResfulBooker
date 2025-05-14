package com.api.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.models.requests.BookingRequest;
import com.api.models.response.BookingResponse;
import com.api.services.BookingService;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class CreateBooking_API {

	@Test
	public void testCreateBookingAPI() {

		BookingRequest createBookingRequest = new BookingRequest.Builder().firstName("Utkarsh").lastName("Test")
				.totalPrice(55000).depositePaid(true).bookingDates("2025-05-10", "2025-05-12").additionalNeeds("Food")
				.Build();

		BookingService bookingService = new BookingService();
		Response response = bookingService.createBooking(createBookingRequest);

		System.out.println(response.asPrettyString());

		BookingResponse bookingResponse = response.as(BookingResponse.class);
		BookingResponse.Booking booking = bookingResponse.getBooking();
		BookingResponse.BookingDates bookingDates = bookingResponse.getBooking().getBookingdates();

		System.out.println(bookingResponse.getBookingid());
		System.out.println(booking.getFirstname());
		System.out.println(booking.getLastname());
		System.out.println(bookingDates.getCheckin());
		System.out.println(bookingDates.getCheckout());

	}
}
