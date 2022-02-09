package sprintProject;
//supplier class with properties defining the table attributes
public class Supplier {
	
	private int supplierId;
    private String productId;
    private double quantity;
    private double salePrice;
    private double wholesale;

	public int getSupplierId() {
        return supplierId;
    }
    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public double getQuantity() {
        return quantity;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    public double getSalePrice() {
        return salePrice;
    }
    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
   }
    public double getWholesale() {
        return wholesale;
}
    public void setWholesale(double wholesale) {
        this.wholesale = wholesale;
    }   
   
   
  //toString()
    @Override
    public String toString() {
        return "SupplierInfo [supplierId=" + supplierId + ", productId=" + productId + ", quantity="
                + quantity + ", salePrice=" + salePrice +", wholesale="+ wholesale +"]";
    }       
}
