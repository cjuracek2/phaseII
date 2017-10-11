package phase1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class PersonFileReader {
	
	public ArrayList<Person> readPersons() {
	Scanner sc = null;
		
		try {
			sc = new Scanner(new File("data/testPerson.dat"));
			sc.nextLine(); // reads the number of records from the first line
			
			// This Person ArrayList stores the Person objects 
			ArrayList<Person> personList = new ArrayList<Person>();
			
			while(sc.hasNext()) {
				String line = sc.nextLine(); // reads each line starting from 2nd line
				String data[] = line.split(";"); // tokenizes the line and stores in a string array 
				
				
				//personcode, name, address, possibly email
				String personCode = data[0];
				String nameTokens[] = data[1].split(",");
				String lastName = nameTokens[0];
				String firstName = nameTokens[1];
				String addressData[] = data[2].split(",");
				String street = addressData[0];
				String city = addressData[1];
				String state = addressData[2];
				String zip = addressData[3];
				String country = addressData[4];
				ArrayList<String> email = new ArrayList<String>();
				if (data.length == 4) {
					
					String emailList[] = data[3].split(",");
					for(int i = 0; i< emailList.length; i++) {
						email.add(emailList[i]);
					}
					
					
				}else {
					 email = null;
				}
				
				
				// Creates an Address object
				Address address = new Address(street,city,state,zip,country);
				
				// Creates a Person object
				Person person = new Person(personCode, firstName, lastName, address, email);
							
				
				// Adds the Person object into Person ArrayList
				personList.add(person);
			}
			sc.close();
			return personList;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}	
	}
}
