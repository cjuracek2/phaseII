package phaseII;

import java.util.ArrayList;

public class indInvoice {
	private int invoiceCode;
	private Customer customer;
	private Person salesperson;
	private String date;
	private ArrayList<Product> productInvList;
	private ArrayList<String> quantity;
	private ArrayList<String> ticketCode;

	//private ArrayList invoices;
	
	
	//Get/set invoice code
	
	public indInvoice(int invoiceCode, Customer customer, Person salesperson, String date, ArrayList<Product> productInvList, ArrayList<String> quantity, ArrayList<String> ticketCode) {
		super();
		this.invoiceCode = invoiceCode;
		this.customer = customer;
		this.salesperson = salesperson;
		this.date = date;
		this.productInvList = productInvList;
		this.quantity = quantity;
		this.ticketCode = ticketCode;
		//this.invoices = invoices;
	}
	public int getInvoiceCode() {
		return invoiceCode;
	}
	public void setInvoiceCode(int invoiceCode) {
		this.invoiceCode = invoiceCode;
	}
	
	
	//get/set customer code
	//get customer info from customers
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	//get/set salesperson code
	//get salesperson info from persons
	
	public Person getSalesperson() {
		return salesperson;
	}
	public void setSalesperson(Person salesperson) {
		this.salesperson = salesperson;
	}
	
	
	
	//set/get date
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	//import product list from invoices
	
	public ArrayList<Product> getProductList() {
		return productInvList;
	}
	public void setProductList(ArrayList<Product> productInvList) {
		this.productInvList = productInvList;
	}
	
	

		
		
	
	public ArrayList<String> getQuantity() {
		return quantity;
	}
	public void setQuantity(ArrayList<String> quantity) {
		this.quantity = quantity;
	}
	
	
	public ArrayList<String> getTicketCode() {
		return ticketCode;
	}
	public void setTicketCode(ArrayList<String> ticketCode) {
		this.ticketCode = ticketCode;
	}
	
	
	//Method for calculating the overall subtotal, taxes, fees of the invoice
	//Loop through the product list 
	
	public double getSubtotal() {
		double allSub = 0;
		int j = 0;
		for (Product p : productInvList) {
			double subtotal = p.getSubtotal(Integer.parseInt(quantity.get(j)));
			allSub = allSub  + subtotal;
			j = j +1;
		}
		return allSub;
	}
	
	public double getTax() {
		double allTax = 0;
		for (Product p : productInvList) {
			double tax = p.getTax();
			if (customer.getType().equals("S")) {
				 tax = 0.0;
			} 
			allTax = allTax + tax;
		}
		return allTax;
	}
	
	
	public double getDiscount() {
		double allDiscount = 0;
		for (Product p : productInvList) {
			double productDiscount = p.getDiscount();
			double studentDiscount = customer.getStudentDiscount();
			double discount = productDiscount + studentDiscount;
			
			allDiscount = allDiscount + discount;
		}
		return allDiscount;
	}
	
	public double getFees() {
		return customer.getFee();
	}
	
	public int getMovieQuantity(int j) {
		int moviequant = 0;
		for(int i = 0; i<productInvList.size(); i++) {
			if (ticketCode.get(j).equals(productInvList.get(i).getProductCode())) {
				moviequant = Integer.parseInt(quantity.get(i));
			}
		}
		return moviequant;
	}
	
	
	
	
}
