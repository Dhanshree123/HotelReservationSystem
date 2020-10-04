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

	public static void findCheapestBestRatedHotelWithRates(String sDate_rate, String eDate_rate) {
		
		LocalDate start = LocalDate.parse(sDate_rate);
		LocalDate end = LocalDate.parse(eDate_rate);
		
		LocalDate OriginalStart = start;
		LocalDate OriginalEnd = end;
		String CheapestHotel = ""; 
		int BestRating = 0;
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
		    
		    if( totalCost == min_rate && h.getRating() > BestRating) {
		        BestRating = h.getRating();
		        CheapestHotel = h.getHotelName();
		    }
		    
		    System.out.println(h.getHotelName()+" "+ totalCost);
			
		}
		
	    System.out.println("Cheapest hotel is : "+CheapestHotel+ " ,total rate is: " + min_rate +" ,Rating: "+BestRating);	
	}

	public static void findBestRatedHotelWithRates(String sDate_Bestrate, String eDate_Bestrate) {
		LocalDate start = LocalDate.parse(sDate_Bestrate);
		LocalDate end = LocalDate.parse(eDate_Bestrate);
		
		LocalDate OriginalStart = start;
		LocalDate OriginalEnd = end;
		String Hotel_name = ""; 
		int BestRating = 0;
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
		    if(h.getRating() > BestRating)
		    {
		    	BestRating = h.getRating();
		    	min_rate = totalCost;
		    	Hotel_name = h.getHotelName();
		    }

		   // System.out.println(h.getHotelName()+" "+ totalCost);
			
		}
		
	    System.out.println("Best rated hotel is : "+Hotel_name+ " ,total rate is: " + min_rate +" ,Rating: "+BestRating);	
		
	}

	public static void addRewardRates(String hName_reward, int rewardWeeklyRate, int rewardWeekEndRate) {
		for(Hotel h: hotelList_rates) {
	    	 if(h.getHotelName().equals(hName_reward)) {
	    		 h.setRewardWeeklyRate(rewardWeeklyRate);
	    		 h.setRewardWeekEndRate(rewardWeekEndRate);
	    	 }
	     }
		
		
	}
	
}