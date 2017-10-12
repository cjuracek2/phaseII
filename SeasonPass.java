package phaseII;
import org.joda.time.DateTime;
import org.joda.time.Days;

public class

SeasonPass extends Product {
	private String name;
	private DateTime startdate;
	private DateTime endDate;
	private double cost;
	private DateTime invDate;
	
	public SeasonPass(String productCode, String type, String name, DateTime startdate, DateTime endDate, double cost) {
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

	public DateTime getStartdate() {
		return startdate;
	}

	public void setStartdate(DateTime startdate) {
		this.startdate = startdate;
	}

	public DateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public void setInvDate(DateTime invDate) {
		this.invDate = invDate;
	}
	
	@Override	
	public double getSubtotal(int quantity) {
		Days startend = Days.daysBetween(startdate, endDate);
		Days endinv = Days.daysBetween(invDate, startdate);
		
		//(cost/days in the season)*days left in the season +8
		return quantity*((cost/startend.getDays())*(endinv.getDays())+8.0);
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
		Days startend = Days.daysBetween(startdate, endDate);
		Days endinv = Days.daysBetween(invDate, startdate);
		return (cost/startend.getDays())*endinv.getDays()+8.0;
	}
	

}
