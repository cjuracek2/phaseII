package phaseII;


public class

ParkingPass extends Product {
	private double parkingFee;

	public ParkingPass(String productCode, String type, double parkingFee) {
		super(productCode, type);
		this.parkingFee = parkingFee;
	}

	public double getParkingFee() {
		return parkingFee;
	}

	public void setParkingFee(double parkingFee) {
		this.parkingFee = parkingFee;
	}
	
	
	//number of free parking passes
	public int getNumFree(int quantitymovie, int quantitypp) {
		return quantitymovie;
	}
	
	
	
	@Override	
	//quantity = quantity parking passes - quantity of tickets
	public double getSubtotal(int quantity) {
		return quantity*parkingFee;
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
		return parkingFee;
	}
	
	
}
