package com.api.models.requests;

import java.util.Map;

public class BookingRequest {

	private String firstname;
	private String lastname;
	private int totalprice;
	private boolean depositpaid;
	private Map<String, Object> bookingdates;
	private String additionalneeds;

	public BookingRequest(String firstname, String lastname, int totalprice, boolean depositpaid,
			Map<String, Object> bookingdates, String additionalneeds) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.totalprice = totalprice;
		this.depositpaid = depositpaid;
		this.bookingdates = bookingdates;
		this.additionalneeds = additionalneeds;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public boolean isDepositpaid() {
		return depositpaid;
	}

	public void setDepositpaid(boolean depositpaid) {
		this.depositpaid = depositpaid;
	}

	public Map<String, Object> getBookingdates() {
		return bookingdates;
	}

	public void setBookingdates(Map<String, Object> bookingdates) {
		this.bookingdates = bookingdates;
	}

	public String getAdditionalneeds() {
		return additionalneeds;
	}

	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}

	@Override
	public String toString() {
		return "CreateBookingRequest [firstname=" + firstname + ", lastname=" + lastname + ", totalprice=" + totalprice
				+ ", depositpaid=" + depositpaid + ", bookingdates=" + bookingdates + ", additionalneeds="
				+ additionalneeds + "]";
	}

	public static class Builder {

		private String firstname;
		private String lastname;
		private int totalprice;
		private boolean depositpaid;
		private Map<String, Object> bookingdates;
		private String additionalneeds;

		public Builder firstName(String firstname) {

			this.firstname = firstname;
			return this;

		}

		public Builder lastName(String lastname) {

			this.lastname = lastname;
			return this;
		}

		public Builder totalPrice(int totalprice) {

			this.totalprice = totalprice;
			return this;
		}

		public Builder depositePaid(boolean depositePaid) {

			this.depositpaid = depositePaid;
			return this;
		}

		public Builder bookingDates(String checkIn, String checkOut) {
			this.bookingdates = new java.util.HashMap<>();
			this.bookingdates.put("checkin", checkIn);
			this.bookingdates.put("checkout", checkOut);
			return this;
		}

		public Builder additionalNeeds(String additionalneeds) {

			this.additionalneeds = additionalneeds;
			return this;
		}

		public BookingRequest Build() {

			BookingRequest createBookingRequest = new BookingRequest(firstname, lastname, totalprice, depositpaid,
					bookingdates, additionalneeds);
			return createBookingRequest;
		}
	}

}
