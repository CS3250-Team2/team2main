
public class ProductInfo {
	
	private String supplierId;
    private String productId;
    private double quantity;
    private double salePrice;
    private double wholesale;

    public ProductInfo (String productId, double quantity, double salePrice,
			double wholesale, String supplierId) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.salePrice = salePrice;
		this.wholesale = wholesale;
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

	public String getSupplierId() {
        return supplierId;
    }
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }
   
   
  //toString()
    @Override
    public String toString() {
        return "ProductInfo [ productId=" + productId + ", quantity="
                + quantity + ",wholesale="+ wholesale +" salePrice=" + salePrice +", supplierId=" + supplierId + "]";
    }       
}
