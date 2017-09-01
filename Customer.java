package spencerhomeappliances;

import java.util.ArrayList;

public class Customer {
	
	//creating three variables 
	
			int customerID;
			String customerName;
			int contactNumber;
			
			//taking array list as bookedProdcutList
			
		ArrayList<Product> bookedProductList=new ArrayList<Product>();
		
		//sing getters and setters for the 3 variables
		
		public int getCustomerID() {
			
			return customerID;
		}
		public void setCustomerID(int customerID) {
			
			this.customerID = customerID;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public int getContactNumber() {
			return contactNumber;
		}
		public void setCustomerNo(int contactNo) {
			this.contactNumber = contactNo;
		}
		//creating Constructor and passing the 3 parameters through it
		//The Constructor creates Customer object with the given id, name &contact no.
		public Customer(int customerID, String customerName, int contactNo) {
			super();
			this.customerID = customerID;
			this.customerName = customerName;
			this.contactNumber = contactNo;
		}
		
		//creating Public void addBookedProduct(Product obj) :
		//The method adds the product which is booked by the customer to his bookedProductList.

		public void addBookedProduct(Product obj){
			obj.setProductStatus("unavailable");
			bookedProductList.add(obj);
		}

	}
	


