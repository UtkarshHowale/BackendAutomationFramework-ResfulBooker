package com.api.models.response;

public class BookingResponse {

	private int bookingid;
	private Booking booking;

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "BookingResponse [bookingid=" + bookingid + ", booking=" + booking + "]";
	}

	public static class Booking {

		private String firstname;
		private String lastname;
		private int totalprice;
		private boolean depositpaid;
		private BookingDates bookingdates;
		private String additionalneeds;

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

		public BookingDates getBookingdates() {
			return bookingdates;
		}

		public void setBookingdates(BookingDates bookingdates) {
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
			return "Booking [firstname=" + firstname + ", lastname=" + lastname + ", totalprice=" + totalprice
					+ ", depositpaid=" + depositpaid + ", bookingdates=" + bookingdates + ", additionalneeds="
					+ additionalneeds + "]";
		}
	}

	public static class BookingDates {

		private String checkin;
		private String checkout;

		public String getCheckin() {
			return checkin;
		}

		public void setCheckin(String checkin) {
			this.checkin = checkin;
		}

		public String getCheckout() {
			return checkout;
		}

		public void setCheckout(String checkout) {
			this.checkout = checkout;
		}

		@Override
		public String toString() {
			return "BookingDates [checkin=" + checkin + ", checkout=" + checkout + "]";
		}
	}
}
