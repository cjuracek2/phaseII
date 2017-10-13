package phaseII;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CustomerReader {
	
	
	
	public Person findPersonByID(String contactCode) {
		PersonFileReader fr = new PersonFileReader();
		List<Person> personList = fr.readPersons();
	
		for (Person p: personList) {
			if(contactCode.equals(p.getPersonCode())) {
				return p;
			}
		}
		return null;
	}
	
	public ArrayList<Customer> readCustomer() {
	Scanner sc = null;
		
		try {
			sc = new Scanner(new File("data/Customers.dat"));
			sc.nextLine(); // reads the number of records from the first line
			
			// This Person ArrayList stores the Customer objects 
			ArrayList<Customer> customerList = new ArrayList<Customer>();
			
			while(sc.hasNext()) {
				String line = sc.nextLine(); // reads each line starting from 2nd line
				String data[] = line.split(";"); // tokenizes the line and stores in a string array 
				
				
				//personcode, name, address
				String customerCode = data[0];
				String type = data[1];
				String contactCode = data[2];
				String name = data[3];
				String addressData[] = data[4].split(",");
				String street = addressData[0];
				String city = addressData[1];
				String state = addressData[2];
				String zip = addressData[3];
				String country = addressData[4];
				
				
				
				Person contact = findPersonByID(contactCode);
				
				
	
				
				// Creates an Address object
				Address address = new Address(street,city,state,zip,country);
				
				// Creates a Customer object
				Customer customer = new Customer(customerCode, type, contact, name, address,false);
				
				
				// Adds the customer object into Customer ArrayList
				customerList.add(customer);
			}
			sc.close();
			return customerList;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}	
	}
}
