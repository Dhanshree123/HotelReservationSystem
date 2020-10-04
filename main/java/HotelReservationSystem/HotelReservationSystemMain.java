package HotelReservationSystem;

import java.text.ParseException;
import java.util.Scanner;

public class HotelReservationSystemMain {

	public static void main(String[] args) throws ParseException {
		System.out.println("Welcome to Hotel Reservartion Program");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Choose the option");
			System.out.println("1.Add hotel with regular rates");
			System.out.println("2.Find Cheapest hotel with regular rates");
			System.out.println("3.Add Hotel with Weekly and Weekend rates");
			System.out.println("4.Find Cheapest hotel with weekly and weekend rates.Date format -(YYYY-MM-DD)");
			System.out.println("5.Add ratings to hotels");
			System.out.println("6.Find Cheapest Best rated hotel with weekly and weekend rates.Date format -(YYYY-MM-DD)");
			System.out.println("7.Find Best Rated hotel with weekly and weekend rates.Date format -(YYYY-MM-DD)");
			System.out.println("8.Exit");
			
			int choice = sc.nextInt();
			
			if(choice == 8)
				break;
			
			switch(choice) {
			case 1:
				System.out.println("Enter hotel name");
				String hotelName = sc.next();
				System.out.println("Enter Regular rate");
				int regularRate = sc.nextInt();
				
				HotelReservationSystem.addHotel(hotelName, regularRate);
				break;
				
			case 2:
				System.out.println("Enter the start date");
				String startDate = sc.next();
				System.out.println("Enter the end date");
				String endDate = sc.next();
				
				HotelReservationSystem.findCheapestHotel(startDate,endDate);
				break;
			
			case 3:
				System.out.println("Enter the hotel name for adding rates");
				String hName = sc.next();
				System.out.println("Enter the Weekly rate");
				int WeeklyRate = sc.nextInt();
				System.out.println("Enter the WeekEnd rate");
				int WeekEndRate = sc.nextInt();
				HotelReservationSystem.addRatesAndHotel(hName,WeeklyRate,WeekEndRate);
				
				break;
				
			case 4:
				System.out.println("Enter the start date");
				String sDate = sc.next();
				System.out.println("Enter the end date");
				String eDate = sc.next();
				
				HotelReservationSystem.findCheapestHotelWithRates(sDate,eDate);
				break;
				
			case 5:
				System.out.println("Enter the hotel name for adding rates");
				String hotelName_rating = sc.next();
				System.out.println("Enter the Rating");
				int rating = sc.nextInt();
				HotelReservationSystem.addRating(hotelName_rating,rating);
				
				break;
				
			case 6:
				System.out.println("Enter the start date");
				String sDate_rate = sc.next();
				System.out.println("Enter the end date");
				String eDate_rate = sc.next();
				HotelReservationSystem.findCheapestBestRatedHotelWithRates(sDate_rate,eDate_rate);
				break;
				
			case 7:
				System.out.println("Enter the start date");
				String sDate_Bestrate = sc.next();
				System.out.println("Enter the end date");
				String eDate_Bestrate = sc.next();
				HotelReservationSystem.findBestRatedHotelWithRates(sDate_Bestrate,eDate_Bestrate);
				break;
				
			default:
				break;
					
			}
		}
		
	}
}
