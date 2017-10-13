package phaseII;


public class

ParkingPass extends Product {
	private String parkingFee;

	public ParkingPass(String productCode, String type, String parkingFee) {
		super(productCode, type);
		this.parkingFee = parkingFee;
	}

	public String getParkingFee() {
		return parkingFee;
	}

	public void setParkingFee(String parkingFee) {
		this.parkingFee = parkingFee;
	}
	
	
	//number of free parking passes
	public int getNumFree(int quantitymovie) {
		return quantitymovie;
	}
	
	
	
	@Override	
	//quantity = quantity parking passes - quantity of tickets
	public double getSubtotal(int quantity) {
		return quantity*Double.parseDouble(parkingFee);
	}
	
	
	@Override
	public double getTax() {
		return .04;
	}
		
	@Override
	public double getDiscount() {
		return 0.0;
	}
	
	@Override
	public double getCost() {
		return Double.parseDouble(parkingFee);
	}
	
	
}
