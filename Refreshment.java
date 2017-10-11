package phaseII;

public class Refreshment extends Product {
	private String name;
	private double cost;
	
	public Refreshment(String productCode, char type, String name, double cost) {
		super(productCode, type);
		this.name = name;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	@Override	
	public double getSubtotal(int quantity) {
		return quantity*cost;
	}
	
	
}
