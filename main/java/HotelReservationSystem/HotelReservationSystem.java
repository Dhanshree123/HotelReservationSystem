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
	
	public static void addHotel(String hotelName, int regularRate) {
		Hotel hotel = new Hotel(hotelName,regularRate);
		hotelList.add(hotel);
	}
	
	public static void findCheapestHotel(String startDate, String endDate) throws ParseException {
		Date start=new SimpleDateFormat("ddMMyyyy").parse(startDate);  
		Date end=new SimpleDateFormat("ddMMyyyy").parse(endDate); 
		
		long numOfDays = TimeUnit.DAYS.convert(end.getTime() - start.getTime(), TimeUnit.MILLISECONDS);
		Hotel cheapestHotel = hotelList.stream().min(Comparator.comparing(i->i.getRegularRate())).orElse(null);
		System.out.println("Cheapest Hotel:- "+cheapestHotel.getHotelName() + ", Total rate:- "+cheapestHotel.getRegularRate()*(numOfDays+1));
		
	}
	
}
