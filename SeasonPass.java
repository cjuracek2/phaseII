package phaseII;


public class

SeasonPass extends Product {
	private String name;
	private String startdate;
	private String endDate;
	private double cost;
	private String invDate;
	
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


	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public void setInvDate(String invDate) {
		this.invDate = invDate;
	}
	
	@Override	
	public double getSubtotal(int quantity) {
		//(cost/days in the season)*days left in the season +8
		return quantity*((cost/(endDate-startdate))*(endDate-invDate)+8.0);
	}
	
	@Override
	public double getTax() {
		return .06;
	}
		
	@Override
	public double getDiscount() {
		return 0.0;
	}
	
	@Override
	public double getCost() {
		return (cost/(endDate-startdate))*(endDate-invDate)+8.0;
	}
	

}
