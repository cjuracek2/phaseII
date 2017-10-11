package phaseII;


public class

ParkingPass extends Product {
	private double parkingFee;

	public ParkingPass(String productCode, char type, double parkingFee) {
		super(productCode, type);
		this.parkingFee = parkingFee;
	}

	public double getParkingFee() {
		return parkingFee;
	}

	public void setParkingFee(double parkingFee) {
		this.parkingFee = parkingFee;
	}
	
	@Override	
	public double getSubtotal(int quantity) {
		return quantity*parkingFee;
	}
	
	
	
}
