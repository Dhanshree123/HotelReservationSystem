package HotelReservationSystem;

public class Hotel {

	private String hotelName;
	private int regularRate;
	private int WeeklyRate;
	private int WeekEndRate;
	
	public Hotel(String hotelName, int regularRate){
		this.hotelName = hotelName;
		this.regularRate = regularRate;
	}
	
	public Hotel(String hotelName, int WeeklyRate,int WeekEndRate){
		this.hotelName = hotelName;
		this.WeeklyRate=WeeklyRate;
		this.WeekEndRate = WeekEndRate;
	}
	
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	public String getHotelName() {
		return hotelName;
	}
	
	public void setRegularRate(int regularRate) {
		this.regularRate = regularRate;
	}
	
	public int getRegularRate() {
		return regularRate;
	}
	public void setWeeklyRate(int regularRate) {
		this.WeeklyRate = WeeklyRate;
	}
	
	public int getWeeklyRate() {
		return WeeklyRate;
	}
	
	public void setWeekEndRate(int regularRate) {
		this.WeekEndRate = WeekEndRate;
	}
	
	public int getWeekEndRate() {
		return WeekEndRate;
	}
	
}
