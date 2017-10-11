package product;

public class ParkingPass extends Product {
	private String parkingFee;

	public ParkingPass(String productCode, char type, String parkingFee) {
		super(productCode, type);
		this.parkingFee = parkingFee;
	}

	public String getParkingFee() {
		return parkingFee;
	}

	public void setParkingFee(String parkingFee) {
		this.parkingFee = parkingFee;
	}
	
	
}
