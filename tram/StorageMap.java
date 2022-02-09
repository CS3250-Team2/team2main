package sprintProject;
 
//hashMap to store the data read, key will be supplierId value will be productId, key will be productId value will be quantity/saleprice/wholesale

import java.util.HashMap;

public class StorageMap {
	
	public static void main(String args[])
    {
	QueDB data = new QueDB();
	HashMap<String, Double> storageProduct = new HashMap<>();
	HashMap<Integer, String> storageSupplier = new HashMap<>();

    // Add keys and values (supplierId, productId)
	Supplier supplier = new Supplier();
	
	String productId = supplier.getProductId();
	Double quantity = supplier.getQuantity();
	Double wholesale = supplier.getWholesale();
	Double saleprice = supplier.getSalePrice();
    Integer supplierId = supplier.getSupplierId();
    
    
	storageProduct.put(productId, quantity);
	storageProduct.put(productId, wholesale);
	storageProduct.put(productId, saleprice);
	storageSupplier.put(supplierId,productId);
	
	
    System.out.println(storageProduct);
    }
	
}
 


