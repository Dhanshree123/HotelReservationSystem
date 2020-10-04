package HotelReservationSystem;

public class Hotel {

	private String hotelName;
	private int regularRate;
	private int rating;
	private int WeeklyRate;
	private int WeekEndRate;
	private int RewardWeeklyRate;
	private int RewardWeekEndRate;
	
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
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public int getRating() {
		return rating;
	}
	public void setWeeklyRate(int WeeklyRate) {
		this.WeeklyRate = WeeklyRate;
	}
	
	public int getWeeklyRate() {
		return WeeklyRate;
	}
	
	public void setWeekEndRate(int WeekEndRate) {
		this.WeekEndRate = WeekEndRate;
	}
	
	public int getWeekEndRate() {
		return WeekEndRate;
	}
	
	public void setRewardWeeklyRate(int RewardWeeklyRate) {
		this.RewardWeeklyRate = RewardWeeklyRate;
	}
	
	public int getRewardWeeklyRate() {
		return RewardWeeklyRate;
	}
	
	public void setRewardWeekEndRate(int RewardWeekEndRate) {
		this.RewardWeekEndRate = RewardWeekEndRate;
	}
	
	public int getRewardWeekEndRate() {
		return RewardWeekEndRate;
	}
	
}