import java.util.HashMap;

public class StorageMap {
    
    public static void main(String args[]) {

        HashMap<String, Double> storageProduct = new HashMap<>();
	HashMap<Integer, String> storageSupplier = new HashMap<>();

   
	Supplier supplier = new Supplier();
	
	String productId = supplier.getProductId();
	Double quantity = supplier.getQuantity();
	Double wholesale = supplier.getWholesale();
	Double saleprice = supplier.getSalePrice();
    Integer supplierId = supplier.getSupplierId();
    
    //Add key and value (productId, attribute of product)
	storageProduct.put(productId, quantity);
	storageProduct.put(productId, wholesale);
	storageProduct.put(productId, saleprice);
	
	 // Add keys and values (supplierId, productId)
	storageSupplier.put(supplierId,productId);
	
	
    System.out.println(storageProduct);
    }
}
