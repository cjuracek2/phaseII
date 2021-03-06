package phaseII;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class ProductExporter{

	public ArrayList<Product> readProduct(){
	try {	
	Scanner lineScanner = new Scanner(new File("data/Products.dat"));
	
	int j = Integer.parseInt(lineScanner.nextLine());
	ArrayList<Product> productList = new ArrayList<Product>();
	int i = 0 ;
	while (lineScanner.hasNextLine()  ) {
		Scanner tokenScanner = new Scanner(lineScanner.nextLine()).useDelimiter(";");
		
		//tokenScanner.close();
		String productCode = tokenScanner.next();
		String tester = tokenScanner.next();
		if(tester.equals("M")) {
			String type = "M";
			Scanner dT = new Scanner( tokenScanner.next() ).useDelimiter(" ");
			String DateTime =  dT.next()+ " " +dT.next();
			dT.close();
			String movieName = tokenScanner.next();
			Scanner addressScanner = new Scanner(tokenScanner.next()).useDelimiter(",");
					String street = addressScanner.next();
					String city = addressScanner.next();
					String state = addressScanner.next();
					String zipCode = addressScanner.next();
					String country =addressScanner.next();
					
			addressScanner.close();
					
			Address myAddress = new Address(street, city, state, zipCode, country);
					
			String screenNo = tokenScanner.next();
			String pricePerUnit = tokenScanner.next();

			
			Product movieTicket = new MovieTicket( productCode , type , DateTime , movieName , myAddress , screenNo , pricePerUnit );
				productList.add(movieTicket);
				
			
		}else if (tester.equals("S")) {
			String type = "S";
			String name = tokenScanner.next();
			String startDate = tokenScanner.next();
			String endDate = tokenScanner.next();
			String cost = tokenScanner.next();
			
			Product seasonPass = new SeasonPass(  productCode , type , name , startDate , endDate , cost );
			productList.add(seasonPass);
			
		}else if (tester.equals("P")) {
			String type = "P";
			String parkingFee = tokenScanner.next();
			
			 Product parkingPass = new ParkingPass( productCode , type , parkingFee );
			 productList.add(parkingPass);
			
		}else if(tester.equals("R")) {
			String type = "R";
			String name = tokenScanner.next();
			String cost = tokenScanner.next();
			
			Product refreshment = new Refreshment( productCode , type ,  name  , cost );
			productList.add(refreshment);
		}
	tokenScanner.close();
	}
	lineScanner.close();
	return productList;
	}catch (FileNotFoundException e) {
		e.printStackTrace();
		return null;
	}
	}
}

