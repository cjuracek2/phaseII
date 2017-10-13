package phaseII;
import org.joda.time.DateTime;
import org.joda.time.Days;

public class

SeasonPass extends Product {
	private String name;
	private String startdate;
	private String endDate;
	private String cost;
	private String invDate;
	
	public SeasonPass(String productCode, String type, String name, String startdate, String endDate, String cost) {
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
		return DateTime.parse(startdate);
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public DateTime getEndDate() {
		return DateTime.parse(endDate);
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public void setCost(String cost) {
		this.cost = cost;
	}
	
	public void setInvDate(String invDate) {
		this.invDate = invDate;
	}
	
	@Override	
	public double getSubtotal(int quantity) {
		Days startend = Days.daysBetween(DateTime.parse(startdate), DateTime.parse(endDate));
		Days endinv = Days.daysBetween(DateTime.parse(invDate), DateTime.parse(startdate));
		
		//(cost/days in the season)*days left in the season +8
		return quantity*((Integer.parseInt(cost)/startend.getDays())*(endinv.getDays())+8.0);
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
		Days startend = Days.daysBetween(DateTime.parse(startdate), DateTime.parse(endDate));
		Days endinv = Days.daysBetween(DateTime.parse(invDate), DateTime.parse(endDate));
		return (Integer.parseInt(cost)/startend.getDays())*endinv.getDays()+8.0;
	}
	

}
