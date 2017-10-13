package phaseII;

import java.util.ArrayList;

public class indInvoice {
	private String invoiceCode;
	private Customer customer;
	private Person salesperson;
	private String date;
	private ArrayList<Product> productInvList;
	private ArrayList<String> quantity;
	private ArrayList<String> ticketCode;

	//private ArrayList invoices;
	
	
	//Get/set invoice code
	
	public indInvoice(String invoiceCode, Customer customer, Person salesperson, String date, ArrayList<Product> productInvList, ArrayList<String> quantity, ArrayList<String> ticketCode) {
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
	public String getInvoiceCode() {
		return invoiceCode;
	}
	public void setInvoiceCode(String invoiceCode) {
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
	
	public int getMovieQuantity(int j) {
		int moviequant = 0;
		for(int i = 0; i<productInvList.size(); i++) {
			if (ticketCode.get(j).equals(productInvList.get(i).getProductCode())) {
				moviequant = Integer.parseInt(quantity.get(i));
				break;
			}else {
				moviequant = 0;
			}
		}
		return moviequant;
	}
	
	public double getSubtotal() {
		double allSub = 0;
		int j = 0;
		for (Product p : productInvList) {
			double subtotal = p.getSubtotal(Integer.parseInt(quantity.get(j)));
			if (p.getType().equals("P")) {
				int moviequant = getMovieQuantity(j);
				int quantitypp =Integer.parseInt(quantity.get(j))-moviequant;
				if (quantitypp<0) {
					quantitypp = 0;
				}
				subtotal = p.getSubtotal(quantitypp);
			} 
			allSub = allSub  + subtotal;
			j = j +1;
		}
		return allSub;
	}
	
	public double getTax() {
		double allTax = 0;
		int i =0;
		for (Product p : productInvList) {
			double tax = p.getTax();
			if (customer.getType().equals("S")) {
				 tax = 0.0;
			} else {
				allTax = allTax + tax*p.getCost()*Integer.parseInt(quantity.get(i));
			}
			i++; 
		}
		return allTax;
	}
	
	//change 
	public double getDiscount() {
		int i = 0;
		double Alldiscount = 0;
		for (Product p : productInvList) {
			
			double productDiscount = p.getDiscount();
			if (p.getType().equals("R")) {
				boolean variable = getRefreshmentDiscount();
				if(variable) {
					productDiscount = p.getDiscount();
				}else {
					productDiscount = 0.0;
				}
			}
			
			Alldiscount = productDiscount*p.getCost()*Integer.parseInt(quantity.get(i))+Alldiscount;
			i++;
		}
		double studentDiscount = customer.getStudentDiscount();
		return Alldiscount-(Alldiscount*studentDiscount);
	}
	
	public double getFees() {
		double fee;
		if (customer.isPaidStudentFee()) {
			fee = 0;
		}else {
			fee = 6.75;
			customer.setPaidStudentFee(true);
		}
		//return customer.getFee();
		return fee;
	}
	
	
	
	public boolean getRefreshmentDiscount() {
		boolean var = false;
		for(Product p:productInvList) {
			if(p.getType().equals("M")) {
				var = true;
				break;
			}else {
				var = false;
			}
			
		}
		return var;
	}
	
	
}
