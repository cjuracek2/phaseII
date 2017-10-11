package phase1;

import java.util.List;


public class DataConverter {

	public static void main(String[] args) {
		
		// Create a FlatFileReader object
		PersonFileReader fr = new PersonFileReader();
		CustomerReader cr = new CustomerReader();
		ProductExporter pe = new ProductExporter();
		//Read product file
		
		/* fr Reads data from the flat file;
		 * Creates objects; and
		 * Stores objects in an ArrayList
		 */
		
		List<Person> personList = fr.readPersons();
		List<Customer> customerList = cr.readCustomer();
		List<Product> productList = pe.readProduct();
		//get productList
		
		// Write Person ArrayList into a Json file
		JsonWriter jWriter = new JsonWriter();
		jWriter.jsonConverter(personList);
		
		//Write Customer ArrayList into a Json file
		JsonWriter jWriterCustomer = new JsonWriter();
		jWriterCustomer.jsonConverterCustomer(customerList);
		
		// Write Product ArrayList into a Json file
		JsonWriter jWriterProduct = new JsonWriter();
		jWriterProduct.jsonConverterProduct(productList);
		
		
		// Write Person ArrayList into an XML file
		 //XMLWriter xmlWriter = new XMLWriter();
	     //xmlWriter.xmlConverter(personList);
	}
}
