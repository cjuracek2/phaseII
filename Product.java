package phaseII;


public abstract class Product {
	private String productCode;
	private char Type;


	//constructor, wont be used in our code
	public Product(String productCode, char type) {
		super();
		this.productCode = productCode;
		Type = type;
	}
	
	//getters and setters, will be overrode in child code
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public char getType() {
		return Type;
	}
	public void setType(char type) {
		Type = type;
	}
	
	abstract public double getSubtotal(int quantity);
	
	abstract public double getTax();
	
	abstract public double getDiscount();
	
	abstract public double getCost();

	
	
}
