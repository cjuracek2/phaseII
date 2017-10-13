package phaseII;

public class Customer {
	
	private String customerCode;
	private String type;
	private Person contact;
	private String name;
	private Address address;
	private double studentDiscount;
	//private double fee;
	private boolean paidStudentFee;
	
	
	
	public Customer(String customerCode, String type, Person contact, String name, Address address, boolean paidStudentFee) {
		super();
		this.customerCode = customerCode;
		this.type = type;
		this.contact = contact;
		this.setName(name);
		this.address = address;
		this.paidStudentFee = false;
	}
	
	
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Person getContact() {
		return contact;
	}
	public void setContact(Person contact) {
		this.contact = contact;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStringType() {
		String whichType;
		if (type.equals("S")) {
			whichType = "Student";
		} else {
			whichType = "General";
		}
		return whichType;
	}


	public double getStudentDiscount() {
		if (type.equals("S")){
			studentDiscount = .08;
		}else {
			studentDiscount = 0;
		}
		return studentDiscount;
	}

	/*public double getFee() {
		if(type.equals("S")) {
			fee = 6.75;
		}else {
			fee = 0.0;
		}
		return fee;
	}*/


	public boolean isPaidStudentFee() {
		return paidStudentFee;
	}


	public void setPaidStudentFee(boolean paidStudentFee) {
		this.paidStudentFee = paidStudentFee;
	}
	
	
		
}
