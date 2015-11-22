package bookeo;

import java.util.ArrayList;

import io.swagger.client.ApiException;
import io.swagger.client.api.BookingsApi;
import io.swagger.client.api.CustomersApi;
import io.swagger.client.model.Booking;
import io.swagger.client.model.Customer;
import io.swagger.client.model.Participants;
import io.swagger.client.model.PeopleNumber;

public class CreateBooking {

	@SuppressWarnings("unused")
	private Customer createCustomer() {
		Customer customer = new Customer();
		customer.setFirstName("Ali");
		customer.setLastName("02");
		customer.setEmailAddress("ali@b.com");

		return customer;
	}

	private Booking createBooking() {
		Booking booking = new Booking();
		booking.setBookingNumber(new Long(System.currentTimeMillis()).toString());

		// Date startDate;
		// startDate = Config.SHORTDATE.parse("2015-11-23");
		// booking.setStartTime(startDate);
		// booking.setEndTime(startDate);

		booking.setProductId("3250FA4EEM151258093DA");
		booking.setEventId("3250FA4EEM151258093DA_3250X46R44151258093DA_2015-11-23");
		Customer customer = new Customer();
		customer.setFirstName("John");
		customer.setLastName("Smith1");
		customer.setEmailAddress("jsmith@google.com");
		customer.setCustomFields(null);
		customer.setPhoneNumbers(null);
		booking.setCustomer(customer);
		booking.setInitialPayments(null);
		booking.setCouponCodes(null);
		booking.setOptions(null);
		booking.setResources(null);

		Participants participants = new Participants();
		ArrayList<PeopleNumber> peopleList = new ArrayList<PeopleNumber>();
		PeopleNumber number = new PeopleNumber();
		number.setNumber(1);
		number.setPeopleCategoryId("Cadults");
		peopleList.add(number);
		participants.setNumbers(peopleList);
		participants.setDetails(null);
		booking.setParticipants(participants);
		booking.setBookingNumber(null);
		return booking;
	}

	public void postCustomer(Customer newCustomer) {
		CustomersApi customerApi = new CustomersApi();
		try {
			// update customerApi String[] authNames = new String[] { "keyAuth",
			// "secretKey" };
			customerApi.customersPost(newCustomer);
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void postBooking(Booking newBooking) {
		BookingsApi bookingApi = new BookingsApi();
		try {
			// update bookingApi String[] authNames = new String[] { "keyAuth",
			// "secretKey" };
			bookingApi.bookingsPost(newBooking, "", false, false, false, false);
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		CreateBooking test = new CreateBooking();
		 //test.postCustomer(test.createCustomer());

		test.postBooking(test.createBooking());
	}
}