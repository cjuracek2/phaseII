package phaseII;

public class MovieTicket extends Product {
	private String movieDate;
	//joda time
	private String movieName;
	private Address address;
	private String screenNo;
	private double pricePerUnit;

	
	public MovieTicket(String productCode, String type, String movieDate, String movieName, Address address,String screenNo, double pricePerUnit) {
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

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	

	
	@Override	
	public double getSubtotal(int quantity) {
		return quantity*pricePerUnit;
	}
	
	@Override
	public double getTax() {
		return .06;
	}
		
	@Override
	public double getDiscount() {
		//7% discount if Tues/Thurs
	}
	
	@Override
	public double getCost() {
		return pricePerUnit;
	}
	
	
}