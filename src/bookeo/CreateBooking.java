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

	private Customer createCustomer(String name, String lastName, String eMail) {
		Customer customer = new Customer();
		customer.setFirstName(name);
		customer.setLastName(lastName);
		customer.setEmailAddress(eMail);
		customer.setCustomFields(null);
		customer.setPhoneNumbers(null);

		return customer;
	}

	private Booking createBooking(Customer customer, String product, String date, String time) {
		Booking booking = new Booking();

		String productId = ProductTools.getInstance().getProductId(product);
		String eventId = new EventTools().getEventId(productId, date, time);

		booking.setProductId(productId);
		booking.setEventId(eventId);

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

		Customer testCustomer = test.createCustomer("Custo", "Santa", "santa@gmail.com");
		// test.postCustomer(testCustomer);
		test.postBooking(test.createBooking(testCustomer, "Tour", "2015-11-27", "09:00"));
	}
}