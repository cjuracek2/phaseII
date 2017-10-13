package phaseII;

import java.time.format.DateTimeFormatter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class MovieTicket extends Product {
	private String movieDate;
	//joda time
	private String movieName;
	private Address address;
	private String screenNo;
	//private double pricePerUnit;
	private String pricePerUnit;

	
	public MovieTicket(String productCode, String type, String movieDate, String movieName, Address address,String screenNo, String pricePerUnit) {
		super(productCode, type);
		this.movieDate = movieDate;
		this.movieName = movieName;
		this.address = address;
		this.screenNo = screenNo;
		this.pricePerUnit = pricePerUnit;
	}

	public String getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getScreenNo() {
		return screenNo;
	}

	public void setScreenNo(String screenNo) {
		this.screenNo = screenNo;
	}

	public String getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(String pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	

	
	@Override	
	public double getSubtotal(int quantity) {
		return quantity*Double.parseDouble(pricePerUnit);
	}
	
	@Override
	public double getTax() {
		return .06;
	}
		
	@Override
	public double getDiscount() {
		double discount;
		//7% discount if Tues/Thurs
		org.joda.time.format.DateTimeFormatter dateStringFormat = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
		//DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
		//DateTime dt = new DateTime(movieDate);
		DateTime date = dateStringFormat.parseDateTime(movieDate);
		
		int day = date.getDayOfWeek();
		if (day ==2) {
			discount = .07;
			
		}else if (day == 4) {
			discount = .07;
		}else {
			discount = 0.;
		}
		return discount;
	}
	
	@Override
	public double getCost() {
		return Double.parseDouble(pricePerUnit);
	}

	@Override
	public String toString(int quantity) {
		return "MovieTicket "+ movieName + " @ " + getAddress().getStreet() + "\n           " + movieDate + " (" + quantity + " units @ $" + getCost()+")                     ";
	}
	
	
	
	
}