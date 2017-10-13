package phaseII;

import java.util.*;
import java.lang.Math.*;

public class InvoiceReport {

	public static void main(String[] args) {
		
		Invoice inv = new Invoice();
		
		ArrayList<indInvoice> invoiceList = inv.readInvoice();
		System.out.println(invoiceList);
		
		//------------------------------------------------------------------------------------------------------------
		//print summary invoice
		//loop through the invoiceList
		//Call the invoice methods to get overall subtotals, fees, etc
	
		
		
		for (indInvoice i : invoiceList) {
			
			double total = (i.getSubtotal() + i.getFees() + (i.getTax()*i.getSubtotal()))* i.getDiscount();
			//format print
			String line = String.format("",i.getInvoiceCode(), i.getCustomer().getName(), i.getCustomer().getType(), i.getSalesperson().getName(), i.getSubtotal(), i.getTax()*i.getSubtotal(), i.getFees(), i.getDiscount()*i.getSubtotal(), total);
			
		}
		

		//Print the rest of the invoices
		//loop through the invoices
		//print customer, salesperson, contact info
		//loop through the product list of the invoices
		ArrayList<String> quantity = new ArrayList<String>();
		ArrayList<String> ticketCode = new ArrayList<String>();
		
		System.out.println("Individual Invoice Detail Report");
		System.out.println("-------------------------------------------------------");
		for (indInvoice in : invoiceList) {
			System.out.println("Invoice" + in.getInvoiceCode());
			System.out.println("-------------------------------------------------------");
			//print salesperson
			System.out.println("Salesperson: " + in.getSalesperson().getLastName() + ", " + in.getSalesperson().getFirstName());
			System.out.println("Customer Information");
			//System.out.println("-------------------------------------------------------");
			System.out.println(in.getCustomer().getName() + " ("+ in.getCustomer().getCustomerCode()+ ")");
			System.out.println("["+in.getCustomer().getStringType() + "]");
			System.out.println(in.getCustomer().getContact().getName());
			System.out.println(in.getCustomer().getContact().getAddress().toString());
			System.out.println("-------------------------------------------------------");
	    	System.out.format("%-10s %-55s %-16s %-16s %-15s", "Code", "Item", "Subtotal", "Tax", "Total");
	    	System.out.format("\n");
	    	

			
			
			//print Customer info
			//print contact info
			
			
			//products
			quantity = in.getQuantity();
			int j = 0;
			double allSub = 0;
			double allTax=0;
		
			for (Product p : in.getProductList()) {
				
				//print product code
				//print product name (toString method)
				//print numUnits quantity.get(j)
				//print cost/unit  getCost method   (with -- free for parking pass method)
				//print subtotal, tax, ProductTotal
				double subtotal = p.getSubtotal(Integer.parseInt(quantity.get(j)));

				if (p.getType().equals("P")) {
					int moviequant = in.getMovieQuantity(j);
					int quantitypp = Math.abs(Integer.parseInt(quantity.get(j))-moviequant);
					if (quantitypp>Integer.parseInt(quantity.get(j))) {
						quantitypp = Integer.parseInt(quantity.get(j));
					}
					subtotal = p.getSubtotal(quantitypp);
				}
				
			
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
