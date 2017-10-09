package phaseII;

import java.util.ArrayList;

public class IndInvoice {
	private int invoiceCode;
	private int customerCode;
	private int salespersonCode;
	private String date;
	private ArrayList productList;
	private ArrayList invoices;
	
	
	//Get/set invoice code
	
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
	
	public ArrayList getProductList() {
		return productList;
	}
	public void setProductList(ArrayList productList) {
		this.productList = productList;
	}
	
	
	
	//get product info for everything on the list
	
	//organize data, format, and put into an array of invoices
	
	public ArrayList getInvoices() {
		return invoices;
	}
	public void setInvoices(ArrayList invoices) {
		this.invoices = invoices;
	}
}
