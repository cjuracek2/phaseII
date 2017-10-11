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
						String productData[] = data[i+4].split(",");
						String productCode = productData[0];
						String quantity = productData[1];
						
						Product product = findProductByID(productCode);
						productInvList.add(product);
					
					}
					
					Customer customer = findCustomerByID(customerCode);
					Person salesperson = findPersonByID(salespersonCode);
					indInvoice invoice = new indInvoice();
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
	
	//print summary invoice

	//Print the rest of the invoices
	
}
