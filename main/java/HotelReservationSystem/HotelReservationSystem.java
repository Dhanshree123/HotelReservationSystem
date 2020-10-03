package HotelReservationSystem;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HotelReservationSystem {

	public static List<Hotel> hotelList = new ArrayList<Hotel>();
	public static List<Hotel> hotelList_rates = new ArrayList<Hotel>();
	public static void addHotel(String hotelName, int regularRate) {
		Hotel hotel = new Hotel(hotelName,regularRate);
		hotelList.add(hotel);
	}
	
}
