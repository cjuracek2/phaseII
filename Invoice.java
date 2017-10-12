package phaseII;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Invoice {
	
	
	public Product findProductByID(String productCode) {
		ProductExporter pr = new ProductExporter();
		List<Product> productList = pr.readProduct();
	
		for (Product p: productList) {
			if(productCode.equals(p.getProductCode())) {
				return p;
			}
		}
		return null;
	}
	
	public Person findPersonByID(String salespersonCode) {
		PersonFileReader fr = new PersonFileReader();
		List<Person> personList = fr.readPersons();
	
		for (Person p: personList) {
			if(salespersonCode.equals(p.getPersonCode())) {
				return p;
			}
		}
		return null;
	}
	
	public Customer findCustomerByID(String customerCode) {
		CustomerReader cr = new CustomerReader();
		List<Customer> customerList = cr.readCustomer();
	
		for (Customer c: customerList) {
			if(customerCode.equals(c.getCustomerCode())) {
				return c;
			}
		}
		return null;
	}

	
	public ArrayList<indInvoice> readInvoice() {
	Scanner sc = null;
			
			 try{
				sc = new Scanner(new File("data/invoice.dat"));
				sc.nextLine(); // reads the number of records from the first line
				
				// This Invoice array list stores the Invoice objects 
				ArrayList<indInvoice> invoiceList = new ArrayList<indInvoice>();
				ArrayList<Product> productInvList	= new ArrayList<Product>();
				ArrayList<String> quantity = new ArrayList<String>();
				ArrayList<String> ticketCode = new ArrayList<String>();
				
				
				while(sc.hasNext()) {
					String line = sc.nextLine(); // reads each line starting from 2nd line
					String data[] = line.split(";"); // tokenizes the line and stores in a string array 
					int length = data.length;
					
					
					//personcode, name, address
					String invoiceCode = data[0];
					String customerCode = data[1];
					String salespersonCode = data[2];
					String date = data[3];
					//separate again 
					for (int i = 0; i<length-4; i++ ) {
						String products[] = data[i+4].split(",");
						
		
					
						for (int j = 0; j< products.length; j++) {
							String productData[] = products[j].split(":");
							String productCode = productData[0];
							quantity.add(productData[1]);
							if (productData.length == 3) {
								 ticketCode.add(productData[2]);
							}else { 
								ticketCode.add(null);
							}
							
							Product product = findProductByID(productCode);
							productInvList.add(product);
							
					
						}
				

					}

					Customer customer = findCustomerByID(customerCode);
					Person salesperson = findPersonByID(salespersonCode);
					indInvoice invoice = new indInvoice(invoiceCode,customer,salesperson,date,productInvList,quantity,ticketCode);
					invoice.add(invoiceList);
				}
				sc.close();
				return invoiceList;
					
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return null;
			}	
	}
				
			 		

	//Import file
	//Parse flat file
	//Read number of lines and loop through IndInvoice that many times
	
	//Send to IndInvoice
	//Get back from IndInvoice
	
	//Add totals to get summary invoice
	
	
	//------------------------------------------------------------------------------------------------------------
	//print summary invoice
	//loop through the invoiceList
	//Call the invoice methods to get overall subtotals, fees, etc
	for (indInvoice i : invoiceList) {
		
		double total = (i.getSubtotal() + i.getFees() + (i.getTax()*i.getSubtotal()))* i.getDiscount();
		//format print
		System.out.print(i.getInvoiceCode(), i.getCustomer().getName(), i.getCustomer().getType(), i.getSalesperson().getName(), i.getSubtotal(), i.getTax()*i.getSubtotal(), i.getFees(), i.getDiscount()*i.getSubtotal(), total));
		
	}
	

	//Print the rest of the invoices
	//loop through the invoices
	//print customer, salesperson, contact info
	//loop through the product list of the invoices
	ArrayList<String> quantity = new ArrayList<String>();
	ArrayList<String> ticketCode = new ArrayList<String>();
	
	
	for (indInvoice i : invoiceList) {
		//print salesperso
		
		//print Customer info
		//print contact info
		
		
		//products
		quantity = i.getQuantity();
		int j = 0;
		double allSub = 0;
		double allTax = 0;
	
		for (Product p : i.getProductList()) {
			
			//print product code
			//print product name (toString method)
			//print numUnits quantity.get(j)
			//print cost/unit  getCost method   (with -- free for parking pass method)
			double subtotal = 0;
			if (p.getType().equals("P")) {
				int moviequant = i.getMovieQuantity(j);
				int quantitypp = Integer.parseInt(quantity.get(j))-moviequant;
				subtotal = p.getSubtotal(quantitypp);
			}else {
				subtotal = p.getSubtotal(Integer.parseInt(quantity.get(j)));
				j = j +1;
			}
			
			
			double tax = p.getTax()*subtotal;
			if (i.getCustomer().getType().equals("S")) {
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
