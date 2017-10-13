package phaseII;

import java.util.*;
import java.lang.Math.*;

public class InvoiceReport {

	public static void main(String[] args) {
		
		Invoice inv = new Invoice();
		
		ArrayList<indInvoice> invoiceList = inv.readInvoice();
		
		
		//------------------------------------------------------------------------------------------------------------
		//print summary invoice
		//loop through the invoiceList
		//Call the invoice methods to get overall subtotals, fees, etc
	
		System.out.println("===================");
		System.out.println( "Executive Summary Report");
		System.out.println("===================");
		System.out.format("%-6s %-29s %-15s %-21s %-15s %-15s %-15s %-15s %-15s \n", "Invoice", "Customer","Type", "Salesperson","Subtotal","Tax","Fees","Discount","Total");
		
		for (indInvoice i : invoiceList) {
			
			double total = (i.getSubtotal() + i.getFees() + i.getTax()- i.getDiscount());
			//format print
			System.out.format("%-6s %-30s %-10s %-26s %-15.2f %-15.2f %-15.2f %-15.2f %-15.2f \n" ,i.getInvoiceCode(), i.getCustomer().getName(), i.getCustomer().getType(), i.getSalesperson().getName(), i.getSubtotal(), i.getTax(), i.getFees(), i.getDiscount(), total);
			
		}
		
		System.out.println("\n\n");
		
		ArrayList<String> quantity = new ArrayList<String>();
		ArrayList<String> ticketCode = new ArrayList<String>();
		
		System.out.println("Individual Invoice Detail Report");
		System.out.println("-------------------------------------------------------");
		
		
		//loop throught the invoices to print the individual summaries
		
		for (indInvoice in : invoiceList) {
			System.out.println("Invoice" + in.getInvoiceCode());
			System.out.println("-------------------------------------------------------");
			System.out.println("Salesperson: " + in.getSalesperson().getLastName() + ", " + in.getSalesperson().getFirstName());
			System.out.println("Customer Information");
			System.out.println(in.getCustomer().getName() + " ("+ in.getCustomer().getCustomerCode()+ ")");
			System.out.println("["+in.getCustomer().getStringType() + "]");
			System.out.println(in.getCustomer().getContact().getName());
			System.out.println(in.getCustomer().getContact().getAddress().toString());
			System.out.println("-------------------------------------------------------");
	    	System.out.format("%-10s %-55s %-16s %-16s %-15s", "Code", "Item", "Subtotal", "Tax", "Total");
	    	System.out.format("\n");
	    
	    	
	    	
			quantity = in.getQuantity();
			int j = 0;
			double allSub = 0;
			double allTax=0;
			
			
			
			//loop through the product list
		
			for (Product p : in.getProductList()) {
				
	
				double subtotal = p.getSubtotal(Integer.parseInt(quantity.get(j)));

				//parking pass is free with each ticket
				if (p.getType().equals("P")) {
					int moviequant = in.getMovieQuantity(j);
					int quantitypp =Integer.parseInt(quantity.get(j))-moviequant;
					if (quantitypp<0) {
						quantitypp = 0;
					}
					subtotal = p.getSubtotal(quantitypp);
				} 
				
				if (p.getType().equals("M")) {
					double discount = p.getDiscount();
					subtotal = subtotal- (discount*subtotal);
				}
				
				if (p.getType().equals("R")) {
					boolean variable = in.getRefreshmentDiscount();
					if(variable) {
						subtotal = subtotal- (subtotal*p.getDiscount());
					}
				}
				
			    //students pay no tax
				double tax = p.getTax()*subtotal;
				if (in.getCustomer().getType().equals("S")) {
					 tax = 0.0;
				} 
				
				double ProductTotal = subtotal + tax;
				
				System.out.format("%-10s %-55s", p.getProductCode(), p.toString(Integer.parseInt(quantity.get(j))));
				System.out.format("%1s %-14.2f %1s %-14.2f %1s %-14.2f \n", "$",subtotal, "$", tax, "$", ProductTotal );
				j = j +1;
				allSub = allSub  + subtotal;
				allTax = allTax + tax;

			}
			System.out.println("\n\n");

			double allTotal = allSub + allTax;
			//print all product subtotal, tax, total
			
			System.out.format("%65s %-30s \n", " ", "---------------------------------------------");
			System.out.print("SUBTOTALS");
			System.out.format("%58s %-14.2f %1s %-14.2f %1s %-15.2f \n", "$", allSub, "$", allTax, "$", allSub+allTax);
			System.out.format("\n \n");
			System.out.println("             Thank you for your purchase!             ");
			System.out.format("\n\n");
			
		}
		
	}
}
