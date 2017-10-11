package phaseII;

import java.util.ArrayList;

public class indInvoice {
	private int invoiceCode;
	private int customerCode;
	private int salespersonCode;
	private String date;
	private ArrayList<Product> productList;
	//private ArrayList invoices;
	
	
	//Get/set invoice code
	
	public indInvoice(int invoiceCode, int customerCode, int salespersonCode, String date, ArrayList<Product> productList) {
		super();
		this.invoiceCode = invoiceCode;
		this.customerCode = customerCode;
		this.salespersonCode = salespersonCode;
		this.date = date;
		this.productList = productList;
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
	
	public int getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}
	
	
	//get/set salesperson code
	//get salesperson info from persons
	
	public int getSalespersonCode() {
		return salespersonCode;
	}
	public void setSalespersonCode(int salespersonCode) {
		this.salespersonCode = salespersonCode;
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
		return productList;
	}
	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}
	
	
	
	//get product info for everything on the list
	
	//organize data, format, and put into an array of invoices
	
	/*public ArrayList getInvoices() {
		return invoices;
	}
	public void setInvoices(ArrayList invoices) {
		this.invoices = invoices;
	}
	*/
}
