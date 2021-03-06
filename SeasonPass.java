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
		DateTime start = new DateTime(startdate);
		DateTime end = new DateTime(endDate);
		DateTime inv = new DateTime(invDate);
		int startend = Days.daysBetween(start.withTimeAtStartOfDay(), end.withTimeAtStartOfDay()).getDays();
		int endinv = Days.daysBetween(end.withTimeAtStartOfDay(), inv.withTimeAtStartOfDay()).getDays();
		
		//(cost/days in the season)*days left in the season +8
		double Subtotal;
		if (endinv >= startend) {
			Subtotal = Double.parseDouble(cost) + 8 ;

		}else {
			Subtotal = (Double.parseDouble(cost)/startend)*(endinv)+8.0;
		}
		return quantity*Subtotal;
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
		DateTime start = new DateTime(startdate);
		DateTime end = new DateTime(endDate);
		DateTime inv = new DateTime(invDate);
		int startend = Days.daysBetween(start.withTimeAtStartOfDay(), end.withTimeAtStartOfDay()).getDays();
		int endinv = Days.daysBetween(end.withTimeAtStartOfDay(), inv.withTimeAtStartOfDay()).getDays();
		double endcost = 0.00;
		if (endinv >= startend) {
			endcost = Double.parseDouble(cost) + 8 ;

		}else {
			endcost = (Double.parseDouble(cost)/startend)*(endinv)+8.0;
		}
		return endcost;
	

	}
	
	@Override
	public String toString(int quantity) {
		return "Season Pass " + getName() + " " + quantity + " units @ $" + getCost()+ ")";
	}

}
