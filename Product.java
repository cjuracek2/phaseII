package phaseII;


public abstract class Product {
	private String productCode;
	private String type;


	//constructor, wont be used in our code
	public Product(String productCode, String type) {
		super();
		this.productCode = productCode;
		this.type = type;
	}
	
	//getters and setters, will be overrode in child code
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	abstract public double getSubtotal(int quantity);
	
	abstract public double getTax();
	
	abstract public double getDiscount();
	
	abstract public double getCost();

	
	
}
