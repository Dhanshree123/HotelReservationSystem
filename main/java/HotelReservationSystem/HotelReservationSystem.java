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
import java.util.stream.Collectors;

public class HotelReservationSystem {

	public static List<Hotel> hotelList_rates = new ArrayList<Hotel>();
	
	
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

	public static void addRewardRates(String hName_reward, int rewardWeeklyRate, int rewardWeekEndRate) {
		for(Hotel h: hotelList_rates) {
	    	 if(h.getHotelName().equals(hName_reward)) {
	    		 h.setRewardWeeklyRate(rewardWeeklyRate);
	    		 h.setRewardWeekEndRate(rewardWeekEndRate);
	    	 }
	     }
		
		
	}

	
	public static long calculateRegularCost(Hotel h,LocalDate start,LocalDate end) {
		
		long totalCost = 0;
		 end = end.plusDays(1);
		  while(!(start.equals(end))) {
			 
			  int day = start.getDayOfWeek().getValue(); 
			  
			if(day == 6 || day== 7)
				totalCost = totalCost + h.getWeekEndRate();
			
			else
				totalCost = totalCost + h.getWeeklyRate();
			
			start = start.plusDays(1);
			
			
		  }
		return totalCost;
	}
	
	//UC 11 Using java stream
	public static void findCheapestBestRatedHotelWithRegularRates(String sDate_Rewardrate, String eDate_Rewardrate) {
		LocalDate start = LocalDate.parse(sDate_Rewardrate);
		LocalDate end = LocalDate.parse(eDate_Rewardrate);
		String CheapestHotel = ""; 
		int BestRating = 0;
		long min_rate = hotelList_rates.stream().map(h->calculateRegularCost(h,start,end)).min(Long::compare).get();
		List<Hotel> min_rate_hotels = hotelList_rates.stream().filter(h->calculateRegularCost(h,start,end) == min_rate).collect(Collectors.toList());
		
		Hotel max_rated_hotel = min_rate_hotels.stream().max((h1,h2) -> h1.getRating()-h2.getRating()).get();
		CheapestHotel = max_rated_hotel.getHotelName();
		BestRating = max_rated_hotel.getRating();
	    System.out.println("Cheapest hotel is : "+CheapestHotel+ " ,total rate is: " + min_rate +" ,Rating: "+BestRating);	
	}
	
}