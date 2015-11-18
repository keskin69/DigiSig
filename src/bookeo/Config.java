package bookeo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Config {
	public static final DateFormat SHORTDATE = new SimpleDateFormat("yyyy-MM-dd");
	public static final DateFormat TIMEFORMAT= new SimpleDateFormat("HH:mm");
	public static final DateFormat URLDATE = new SimpleDateFormat("yyyy'%2d'MM'%2d'dd'T'HH'%3a'mm'%3a'ss'%2b02%3a00'");
	public static final String APIBASE = "https://api.bookeo.com/v2/bookings?apiKey=AMRYCLFWHXMJ4FF6X4JKK22166KCLK12EDE727CC6&secretKey=jxjIeX8QFjltj1wY56UFDs5KAgAGCF72";

}
