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
	
	public static void findCheapestHotel(String startDate, String endDate) throws ParseException {
		Date start=new SimpleDateFormat("ddMMyyyy").parse(startDate);  
		Date end=new SimpleDateFormat("ddMMyyyy").parse(endDate); 
		
		long numOfDays = TimeUnit.DAYS.convert(end.getTime() - start.getTime(), TimeUnit.MILLISECONDS);
		System.out.println(numOfDays+1);
		Hotel cheapestHotel = hotelList.stream().min(Comparator.comparing(i->i.getRegularRate())).orElse(null);
		System.out.println(cheapestHotel.getHotelName());
		
	}
	
	public static void addRatesAndHotel(String hName, int weeklyRate, int weekEndRate) {
		Hotel hotel = new Hotel(hName,weeklyRate,weekEndRate);
		hotelList_rates.add(hotel);
	}
	
	public static void addRating(String hotelName, int rating) {
	     for(Hotel h: hotelList_rates) {
	    	 if(h.getHotelName().equals(hotelName)) {
	    		 h.setRating(rating);
	    	 }
	     }
	}
	
	public static void findCheapestHotelWithRates(String startDate, String endDate) throws ParseException {
		LocalDate start = LocalDate.parse(startDate);
		LocalDate end = LocalDate.parse(endDate);
		
		LocalDate OriginalStart = start;
		LocalDate OriginalEnd = end;
		String CheapestHotel = ""; 
		long min_rate = 1000000000;
		
		for(Hotel h: hotelList_rates) {
			
		 long totalCost = 0;
		 start = OriginalStart;
		 end = OriginalEnd.plusDays(1);
		  while(!(start.equals(end))) {
			 
			  int day = start.getDayOfWeek().getValue(); 
			  
			if(day == 6 || day== 7)
				totalCost = totalCost + h.getWeekEndRate();
			
			else
				totalCost = totalCost + h.getWeeklyRate();
			
			start = start.plusDays(1);
			
			
		  }
		    if(totalCost < min_rate)
		    {
		    	min_rate = totalCost;
		    	CheapestHotel = h.getHotelName();
		    	
		    }
		    System.out.println(h.getHotelName()+" "+ totalCost);
			
		}
		
	    System.out.println("Cheapest hotel is : "+CheapestHotel+ " total rate is " + min_rate);	
	}
	
}
