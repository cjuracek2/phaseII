package phaseIV.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import phaseIV.sql.DatabaseInfo;
import phaseII.Address;
import phaseII.Customer;
import phaseII.MovieTicket;
import phaseII.ParkingPass;
import phaseII.Person;
import phaseII.Product;
import phaseII.Refreshment;
import phaseII.SeasonPass;
import phaseII.indInvoice;



public class DBReader {

	
	public ArrayList<String> getEmails(String PersonID){
		ArrayList<String> emailList = new ArrayList<String>();
		String query = "SELECT Email FROM Emails WHERE PersonID LIKE ?";
		Connection conn = DatabaseInfo.getConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, PersonID);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				emailList.add(rs.getString("Email"));
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return emailList;
		
		//get email list
		//query to find the email list
		//return the email list and use to create the person objects
		
	}
	
	
	//Get Person List ** and have a get person(id) 
	
	public Person getDetailedPerson(String PersonID) {
		//TODO: implement this method
		
		//query to get the address
		//get the personID
		//getEmails(PersonID)to get the email list
				
		//query to get everything else to make the person obj
		Person p = new Person();
		Address a = new Address();
		
		String query = "SELECT * FROM Person WHERE PersonID LIKE ?";
		Connection conn = DatabaseInfo.getConnection();
		
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		//need a empty address object and set all address attributes to use with Person
		
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, PersonID);
			rs = ps.executeQuery();
			if(rs.next()) {
				// Person setters
				p.setPersonCode(rs.getString("PersonID"));
				p.setFirstName(rs.getString("FirstName"));
				p.setLastName(rs.getString("LastName"));
				ArrayList<String> emailList = getEmails(rs.getString("PersonID"));
				p.setEmail(emailList);
				//Address Setters
				a.setStreet(rs.getString("Address"));
				a.setCity(rs.getString("City"));
				a.setState(rs.getString("State"));
				a.setZipCode(rs.getString("ZipCode"));
				a.setCountry(rs.getString("Country"));
				//Set address
				p.setAddress(a);
			}
		rs.close();
		conn.close();
			
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return p;
		
	}
	
	public List<Person> getPersons(){
		
		ArrayList<Person> personList = new ArrayList<Person>();
		String query = "SELECT PersonID FROM Person";
		Connection conn = DatabaseInfo.getConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				Person newperson = getDetailedPerson(rs.getString("PersonID"));
				personList.add(newperson);
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return personList;
		//return list of all people
	}
	//--------------------------------------------------------------------------------------------------------------------
	//get Customer list
	
	public Customer getDetailedCustomer(String CustomerID) {
		//query to get address
		//get person (contact) object
		//query to get Customer and make the object
		Customer c = new Customer();
		Address a = new Address();
		
		String query = "SELECT * FROM Customer WHERE CustomerID LIKE ?";
		Connection conn = DatabaseInfo.getConnection();
		
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, CustomerID);
			rs = ps.executeQuery();
			if(rs.next()) {
				//setters
				//call object
				
				c.setCustomerCode(rs.getString("CustomerID"));
				c.setType(rs.getString("CustomerType"));
				Person contact = getDetailedPerson(rs.getString("PersonID"));
				c.setContact(contact);
				c.setName(rs.getString("CustomerName"));
				//Address Setters
				a.setStreet(rs.getString("Address"));
				a.setCity(rs.getString("City"));
				a.setState(rs.getString("State"));
				a.setZipCode(rs.getString("ZipCode"));
				a.setCountry(rs.getString("Country"));
				//Set address
				c.setAddress(a);

			}
		rs.close();
		conn.close();
			
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return c;
		
	}
	
	public List<Customer> getCustomers(){
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		String query = "SELECT CustomerID FROM Customer";
		Connection conn = DatabaseInfo.getConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				Customer newcustomer = getDetailedCustomer(rs.getString("CustomerID"));
				customerList.add(newcustomer);
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return customerList;
		
		
		//return ArrayList<Customer>
	}
	
	//------------------------------------------------------------------------------------------------------------------
	
	public MovieTicket getDetailedMovie(String ProductID) {
		
		//get everything to create the object
		//if type == ...create object of that type
		
		MovieTicket pr = new MovieTicket();
		
		String query = "SELECT * FROM Product WHERE ProductID LIKE ?";
		Connection conn = DatabaseInfo.getConnection();
		
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, ProductID);
			rs = ps.executeQuery();
			if(rs.next()) {
					pr.setProductCode(rs.getString("ProductID"));
					pr.setType(rs.getString("ProductType"));
					pr.setMovieDate(rs.getString("ProductDate"));
					pr.setMovieName(rs.getString("ProductName"));
					pr.setScreenNo(rs.getString("ScreenNo"));
					pr.setAddress(rs.getString("Address"));
					pr.setPricePerUnit(rs.getString("ProductCost"));
				}
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return pr;
				
	}
	
	public SeasonPass getDetailedSeasonPass(String ProductID) {
		
		SeasonPass pr = new SeasonPass();
		
		String query = "SELECT * FROM Product WHERE ProductID LIKE ?";
		Connection conn = DatabaseInfo.getConnection();
		
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, ProductID);
			rs = ps.executeQuery();
			if(rs.next()) {
		
					pr.setProductCode(rs.getString("ProductID"));
					pr.setType(rs.getString("ProductType"));
					pr.setName(rs.getString("ProductName"));
					pr.setStartdate(rs.getString("ProductStartDate"));
					pr.setEndDate(rs.getString("ProductEndDate"));
					pr.setCost(rs.getString("ProductCost"));
					
				}
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return pr;
		
	}
	
	public Refreshment getDetailedRefreshment(String ProductID) {
		
		Refreshment pr = new Refreshment();
		
		String query = "SELECT * FROM Product WHERE ProductID LIKE ?";
		Connection conn = DatabaseInfo.getConnection();
		
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, ProductID);
			rs = ps.executeQuery();
			if(rs.next()) {
				
					pr.setProductCode(rs.getString("ProductID"));
					pr.setType(rs.getString("ProductType"));
					pr.setName(rs.getString("ProductName"));
					pr.setCost(rs.getString("ProductCost"));
					
				}
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return pr;
		
	}
	
	public ParkingPass getDetailedParkingPass(String ProductID) {
		
		ParkingPass pr = new ParkingPass();
		
		String query = "SELECT * FROM Product WHERE ProductID LIKE ?";
		Connection conn = DatabaseInfo.getConnection();
		
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, ProductID);
			rs = ps.executeQuery();
			if(rs.next()) {
			
					pr.setProductCode(rs.getString("ProductID"));
					pr.setType(rs.getString("ProductType"));
					pr.setParkingFee(rs.getString("ProductCost"));
			}
			
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return pr;
	
		
	}
	
	
	
	public ArrayList<Product> getProducts(String InvoiceID){
		ArrayList<Product> productList = new ArrayList<Product>();
		String query = "SELECT ProductType, ProductList.ProductID FROM ProductList JOIN Product ON ProductList.ProductID = Product.ProductID WHERE InvoiceID LIKE ?";
		Connection conn = DatabaseInfo.getConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, InvoiceID);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				if(rs.getString("ProductType").equals("M")) {
					Product newproduct = getDetailedMovie(rs.getString("ProductID"));
					productList.add(newproduct);
				}else if (rs.getString("ProductType").equals("S")) {
					Product newproduct = getDetailedSeasonPass(rs.getString("ProductID"));
					productList.add(newproduct);
				}else if (rs.getString("ProductType").equals("P")){
					Product newproduct = getDetailedParkingPass(rs.getString("ProductID"));
					productList.add(newproduct);
				}else if (rs.getString("ProductType").equals("R")){
					Product newproduct = getDetailedRefreshment(rs.getString("ProductID"));
					productList.add(newproduct);
				}
					
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	
		return productList;
		
	}
	
	//----------------------------------------------------------------------------------------------------------------
	
	public indInvoice getDetailedInvoice(String InvoiceID) {
		indInvoice i = new indInvoice();
		
		String query = "SELECT * FROM Invoice WHERE InvoiceID LIKE ?";
		Connection conn = DatabaseInfo.getConnection();
		
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, InvoiceID);
			rs = ps.executeQuery();
			if(rs.next()) {
				//setters
				//call object
				i.setInvoiceCode(rs.getString("InvoiceID"));
				Customer customer = getDetailedCustomer(rs.getString("CustomerID"));
				i.setCustomer(customer);
				Person salesperson = getDetailedPerson(rs.getString("PersonID"));
				i.setSalesperson(salesperson);
				i.setDate(rs.getString("InvoiceDate"));
				ArrayList<Product> invProductList = getProducts(rs.getString("InvoiceID"));
				i.setProductList(invProductList);
				
				ArrayList<String> quantity = getQuantity(rs.getString("InvoiceID"));
				i.setQuantity(quantity);
				
				ArrayList<String> ticketCode = getTicketCode(rs.getString("InvoiceID"));
				i.setTicketCode(ticketCode);
			}
			
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return i;
		
		
	}
	
	public ArrayList<String> getQuantity(String InvoiceID){
		ArrayList<String> quantity = new ArrayList<String>();
		String query = "SELECT Quantity FROM ProductList WHERE InvoiceID LIKE ?";
		//add the quanities for one invoice into an array
		Connection conn = DatabaseInfo.getConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, InvoiceID);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				quantity.add(rs.getString("Quantity"));
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return quantity;
				
	}
	
	public ArrayList<String> getTicketCode(String InvoiceID){
		ArrayList<String> ticketCode = new ArrayList<String>();
		String query = "SELECT AssociatedTicket FROM ProductList WHERE InvoiceID LIKE ?";
Connection conn = DatabaseInfo.getConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, InvoiceID);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				ticketCode.add(rs.getString("AssociatedTicket"));
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return ticketCode;
	}
	
	public ArrayList<indInvoice> getInvoices(){
		ArrayList<indInvoice> invoiceList = new ArrayList<indInvoice>();
		String query = "SELECT InvoiceID FROM Invoice";
		Connection conn = DatabaseInfo.getConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				indInvoice newinvoice = getDetailedInvoice(rs.getString("InvoiceID"));
				invoiceList.add(newinvoice);
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return invoiceList;
		
	}
	
}
