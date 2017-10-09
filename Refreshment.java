package phaseII;

public class Refreshment extends Product {
	private String name;
	private String cost;
	
	public Refreshment(String productCode, char type, String name, String cost) {
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

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}
	
	
}
