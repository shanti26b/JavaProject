package spencerhomeappliances;

import java.util.ArrayList;

public class RetailStore{
//RetailStore class should know about the storeName,
	//customers registered with the store and product details available in the store.
	//RetailStore holds following responsibilities. Implement the
	//below mentioned responsibilities for RetailStore class.

	String storeName;
	ArrayList<Customer> customerList=new ArrayList<Customer>();
	ArrayList<Product> productList=new ArrayList<Product>();
	
  //	RetailStore(String storeName):
	//	The constructor initialize the storeName with the given input value.

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public RetailStore(String storeName) {
		super();
		this.storeName = storeName;
	}
	
   //	public int generateCustomerID()
	  //This method generates the customerID by incrementing the value of previous customer’s ID by 1. The
	 //value of Customer Id is initially set to zero. For the first customer added to
	 //the system the ID should be 1,for the second customer, ID should be 2 and so on.
	
	public int generateCustomerID()
	{
		int count=0;
		int customerId=0;
		if(customerList.size()==0)
			customerId=1;
		else
		{
			for(Customer cust:customerList)
			{
				count++;
				if(count==customerList.size())
				{	
					customerId=cust.getCustomerID()+1;
					break;
				}
			}
		}
		 //This method  returns the ID generated for the customer
		return customerId;
	}
	
	//public int generateProductID() 
	 //This method generates the productID by incrementing the value of previous product’s ID by 1. The
	//value of productId is initially set to zero. For the first product added to the
	//system the ID should be 1,for the second product , ID should be 2 and so on.
	public int generateProductID()
	{
		int count=0;
		int productId=0;
		//using if loop to set the size of the product list 
		if(productList.size()==0)
			productId=1;
		else
		{
			for(Product prod:productList)
			{
				count++;
				if(count==productList.size())
				{
					productId=prod.getProductID()+1;
					break;
				}
			}
		}
		
		//This method  returns the ID generated for the product
		return productId;
		
	}
	//public void addCustomer(String name,int contactNo)
	// this method creates a customer ID , with that it creates a customer object and
	//then it adds to the customerList of RetailStore
 public void addCustomer(String name,int contactNo){

	   //To create the customerId,using the generateCustomerID method.
	int custId=generateCustomerID();
	Customer c=new Customer(custId,name,contactNo);
		customerList.add(c);
				
}
 // public void addProduct(String name,String status,double price) 
 // This  method creates a product ID , with that it creates a product object and then
 // it adds to the productList of RetailStore
	public void addProduct(String name,String status,double price, int i){
		
		//To create the productId,using generateProductID method
			int prodId=generateProductID();
			
			Product p=new Product(prodId, name,price);
			p.getProductStatus(status);
			productList.add(p);		
			
		}

	//public int checkProductAvailability(String ProductName) - The
	//method returns the count of products which are in status “Available” with the given name .
 public int checkProductAvailability(String ProductName){

	int count=0;
	for(Product prod:productList)
		
		if((prod.getProductName().equals(ProductName)) && (prod.getProductStatus(null).equals("Available"))){
			
			count++;
			}
	if(count>0){
	System.out.println("available");
	}
	
	return count;
}

	
	public void display() {
		
		for(Customer cust:customerList){
			System.out.println("Name: " +cust.getCustomerName()+" Number :  "+cust.getContactNumber()+" ID: "+cust.getCustomerID());
		}
		for(Product pd:productList){
			System.out.println("Pd Name  : "+pd.getProductName()+"Price  : "+pd.getProductPrice()+ " P ID   : "+pd.getProductID()+"    status   :"+pd.getProductStatus( null ));
			
		}
	
	}
	
	//The method checks for the availability of the given
	//product in the productList of retail store .If the required number of products
	//are available in the store , then that many products are booked which means
	//that ,that many products are being added to the bookedProductList of customer.
	public int bookProduct(int CustomerID,String ProductName, int NumberOfProduct) 
	{
		int availProduct=-1;
		int count1=0;
		int count2=0;
		availProduct=checkProductAvailability(ProductName);
		int count3=availProduct;
		int count4=NumberOfProduct;
		
		loop:	for(Customer cust:customerList)
			{
				count1++;
				if(cust.getCustomerID()==CustomerID)
				{
					//it gets the customer Id after it asks for product list
					for(Product prod:productList)
					{
						count2++;
						if(prod.getProductName().equals(ProductName))
						{	
							
							if(availProduct<=NumberOfProduct)
								{cust.addBookedProduct(prod);
								count3--;
							if(count3==0)
									break loop;
							}
							if(availProduct>NumberOfProduct)

							{availProduct=NumberOfProduct;
							cust.addBookedProduct(prod);
								count4--;
							if(count4==0)
									break loop;}
							
						}
						else if(count2==productList.size())
						{availProduct=0;break loop;}
					}
					
				}
				else if(count1==customerList.size())
					{availProduct=-1;break loop;}
			}
		
	return availProduct;
	}
	
	public double calculateNetAmount(int customerID, double discount)
	{
			double cost=0;
			for(Customer cust:customerList)
				if(cust.getCustomerID()==customerID)
					{
						ArrayList<Product> prodList1=cust.bookedProductList;
					
						for(Product p:prodList1)
							{cost+=p.getProductPrice();
							
							}
						
						break;
					}
					
			cost=cost-(cost*discount);
			System.out.println("the amount is "+ cost);
			return cost;
	}
	  
	public void addProduct(String name, String status, int price, int i) {
		// TODO Auto-generated method stub
		
	}
		
	
}