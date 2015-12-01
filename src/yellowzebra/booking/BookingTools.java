package yellowzebra.booking;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.swagger.client.Utils;
import io.swagger.client.model.Booking;
import io.swagger.client.model.BookingsList;
import io.swagger.client.model.PeopleNumber;

public class BookingTools extends Table {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3690890501153582054L;
	private Gson gson = null;
	private String pageNavigationToken = null;

	public BookingTools() {
		gson = new GsonBuilder().setDateFormat(Config.API_DATE).create();
	}

	public void getTodayBookings() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());

		cal.add(Calendar.DATE, 1);
		String endTime = "endTime=" + Config.URLDATE.format(cal.getTime());

		cal.add(Calendar.DATE, -1);
		String startTime = "startTime=" + Config.URLDATE.format(cal.getTime());

		String urlParam = startTime + "&" + endTime;

		addHeader("Booking Number");
		addHeader("Product");
		addHeader("Start Time");
		addHeader("End Time");
		addHeader("Participant");
		addHeader("Detail");
		addHiddenHeader("E-Mail");
		addHiddenHeader("Address");
		addHiddenHeader("Phone");

		getNextPage(urlParam, null);
	}

	public void getNextPage(String param, String pageNumber) {
		String response = null;
		String urlStr = null;

		if ((pageNavigationToken == null) && (pageNumber == null)) {
			urlStr = param;
		} else if ((pageNavigationToken != null) && (pageNumber != null)) {
			urlStr = "pageNavigationToken=" + pageNavigationToken + "&pageNumber=" + pageNumber;
		}

		try {
			URL url = new URL(Config.APIBASE + "&" + urlStr);
			response = (String) Utils.readObject();
			//response = IOUtils.toString(new InputStreamReader(url.openStream()));
			System.out.println(response);
			// Utils.writeObject(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		BookingsList bookingsList = gson.fromJson(response, BookingsList.class);
		processPage(bookingsList);

		if (bookingsList.getInfo().getTotalPages() > bookingsList.getInfo().getCurrentPage()) {
			getNextPage(param, new Integer(bookingsList.getInfo().getCurrentPage() + 1).toString());
		}
	}

	private void processPage(BookingsList bookingsList) {
		if (bookingsList != null) {
			for (Booking booking : bookingsList.getData()) {
				String todayDate = null;
				todayDate = Config.SHORTDATE.format(new Date());

				String bookingDate = Config.SHORTDATE.format(booking.getStartTime());

				if (todayDate.equals(bookingDate) && (booking.getCanceled() == false)) {
					addNewRow();
					addCol(booking.getBookingNumber());
					addCol(booking.getProductName());
					addCol(Config.TIMEFORMAT.format(booking.getStartTime()).toString());
					addCol(Config.TIMEFORMAT.format(booking.getEndTime()).toString());

					String pStr = "";
					for (PeopleNumber people : booking.getParticipants().getNumbers()) {
						pStr += people.getNumber().toString() + " " + people.getPeopleCategoryId() + "<BR>";
					}
					addCol(pStr);

					addCol(booking.getTitle());

					addCol("");
					addCol("");
					addCol("");
				}
			}

			pageNavigationToken = bookingsList.getInfo().getPageNavigationToken();
		}
	}

	public static void main(String args[]) {
		BookingTools bookings = new BookingTools();
		bookings.getTodayBookings();
		System.out.println(bookings.getHTML("Table1"));
	}

}
