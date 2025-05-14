package com.api.services;

import com.api.models.requests.BookingRequest;

import io.restassured.response.Response;

public class BookingService extends BaseService {

	public Response createBooking(BookingRequest payload) {

		return postRequest(payload, "booking");
	}

	public Response getBooking(int bookingId) {

		return getRequest("booking/" + bookingId);
	}

	public Response updateBooking(String token, BookingRequest payload, int bookingId) {
		setAuthToken(token);
		return putRequest(payload, "booking/" + bookingId);
	}

	public Response deleteBooking(String token, int bookingId) {

		setAuthToken(token);
		return deleteRequest("booking/" + bookingId);
	}

}
