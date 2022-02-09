CREATE database Sprint1;
use Sprint1;
CREATE table productInfo(ProductID CHAR(12),
						 Quantity double,
                         Wholesale double,
                         Saleprice double,
                         SupplierID CHAR(8));
select * FROM productInfo;