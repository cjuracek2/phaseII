package phaseII;


public class

SeasonPass extends Product {
	private String name;
	private String startdate;
	private String endDate;
	private double cost;
	
	public SeasonPass(String productCode, char type, String name, String startdate, String endDate, double cost) {
		super(productCode, type);
		this.name = name;
		this.startdate = startdate;
		this.endDate = endDate;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
