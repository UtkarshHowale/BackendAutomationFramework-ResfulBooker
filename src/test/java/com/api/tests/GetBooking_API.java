package com.api.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.services.BookingService;

import io.restassured.response.Response;

@Listeners(com.api.filters.TestListener.class)
public class GetBooking_API {
	
	@Test
	public void testGetBookingAPI() {
		
		BookingService bookingService = new BookingService();
		Response response = bookingService.getBooking(1620);
		System.out.println(response.asPrettyString());
	}

}
