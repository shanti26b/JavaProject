package spencerhomeappliances;

public class Product {
	//creating four variables of the product details
		public int productID;
		String productName;
		//Initially the status of the product is set to Available
		String productStatus ="available";
		double productPrice;
		
		//using getters and setters we are initializing the methods
		public  String getProductStatus(String status) {
			return productStatus;
		}
		public void setProductStatus(String productStatus) {
			this.productStatus = productStatus;
		}
		public int quantity;
		
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public int getProductID() {
			return productID;
		}
		public void setProductID(int productID) {
			this.productID = productID;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public double getProductPrice() {
			return productPrice;
		}
		public void setProductPrice(double productPrice) {
			this.productPrice = productPrice;
		}
		
		//(int productID,String productName, double ProductPrice)
		//The constructor initializes the value of productID, name & price with the given values
		public Product(int productID, String productName, double productPrice) {
			super();
			this.productID = productID;
			this.productName = productName;
			this.productPrice = productPrice;
			

		}
		
		
		
		

	}
	


