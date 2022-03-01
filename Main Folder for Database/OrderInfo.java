import java.util.Date;
//import java.time.LocalDate;

public class OrderInfo {//extends CustomerInfo{
		private String userName;
		private String password;
		private String authorization;
		private Date date;
	    private String cust_email;
	    private double cust_location;
	    private String orderproductId;
	    private double orderquantity;
	    

	    public OrderInfo (Date date, String cust_email, double cust_location, String orderproductId,double orderquantity )
	    {	
	    super();
	    this.date = date;
		this.cust_email = cust_email;
		this.cust_location = cust_location;
		this.orderproductId = orderproductId;
		this.orderquantity = orderquantity;
	    }
	    
	    public String getEmail() {
	        return cust_email;
	    }
	    public void setEmail(String cust_email) {
	        this.cust_email = cust_email;
	    }
	    public double getLocation() {
	        return cust_location;
	    }
	    public void setLocation(double cust_location) {
	        this.cust_location = cust_location;
	    }
	    public String getOrderproductId() {
	        return orderproductId;
	    }
	    public void setorderproductId(String orderproductId) {
	        this.orderproductId = orderproductId;
	   }
	    public double getOrderquantity() {
	        return orderquantity;
	}
	    public void setOrderquantity(double orderquantity) {
	        this.orderquantity = orderquantity;
	    } 

		public Date getDate() {
	        return date;
	    }
	    public void setDate(Date date) {
	        this.date = date;
	    }
	   
	   
	  //toString()
	    @Override
	    public String toString() {
	        return "OderInfo [ Date =" + date + ", customer email ="
	                + cust_email + ",customer location ="+ cust_location +" product Id =" + orderproductId +", order quantity=" + orderquantity + "]";
	    } 
}
