package phaseII;

import java.util.*;

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
		
		
		for (indInvoice in : invoiceList) {
			//print salesperson
			
			//print Customer info
			//print contact info
			
			
			//products
			quantity = in.getQuantity();
			int j = 0;
			double allSub = 0;
			double allTax = 0;
		
			for (Product p : in.getProductList()) {
				
				//print product code
				//print product name (toString method)
				//print numUnits quantity.get(j)
				//print cost/unit  getCost method   (with -- free for parking pass method)
				//print subtotal, tax, ProductTotal
				double subtotal = p.getSubtotal(Integer.parseInt(quantity.get(j)));

				if (p.getType().equals("P")) {
					int moviequant = in.getMovieQuantity(j);
					int quantitypp = Integer.parseInt(quantity.get(j))-moviequant;
					subtotal = p.getSubtotal(quantitypp);
				}
				j = j +1;
			
				double tax = p.getTax()*subtotal;
				if (in.getCustomer().getType().equals("S")) {
					 tax = 0.0;
				} 
				
				double ProductTotal = subtotal + tax;
			
				allSub = allSub  + subtotal;
				allTax = allTax + tax;
			}
			
			double allTotal = allSub + allTax;
			//print all product subtotal, tax, total
			
			
			
		}
		
	}
}
