package phaseII;

public class Customer {
	
	private String customerCode;
	private String type;
	private Person contact;
	private String name;
	private Address address;
	private double studentDiscount;
	
	
	
	public Customer(String customerCode, String type, Person contact, String name, Address address) {
		super();
		this.customerCode = customerCode;
		this.type = type;
		this.contact = contact;
		this.setName(name);
		this.address = address;
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


	public double getStudentDiscount() {
		return studentDiscount;
	}

	public void setStudentDiscount(double studentDiscount) {
		if (type.equals("S")){
			studentDiscount = 8;
		}else {
			studentDiscount = 0;
		}
		this.studentDiscount = studentDiscount;
	}
		
}
