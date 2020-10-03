package HotelReservationSystem;

import java.text.ParseException;
import java.util.Scanner;

public class HotelReservationSystemMain {

	public static void main(String[] args) throws ParseException {
		System.out.println("Welcome to Hotel Reservartion Program");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Choose the option");
			System.out.println("1.Add hotel");
			System.out.println("2.Find Cheapest hotel");
			System.out.println("3.Exit");
			
			int choice = sc.nextInt();
			
			if(choice == 3)
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
			}
		}
		
	}
}
