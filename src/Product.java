import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Products")
public class Product {
    @DatabaseField(id = true)
    String productCode;
    @DatabaseField
    String productName;
    @DatabaseField
    String productLine;
    String productScale;
    String productVendor;
    String productDescription;
    int quantityInStock;
    double buyPrice;
    double MSRP;

    Product(){}

    public Product(String productCode, String productName, String productLine, String productScale,
                   String productVendor, String productDescription, int quantityInStock, double buyPrice, double MSRP) {
        this.productCode = productCode;
        this.productName = productName;
        this.productLine = productLine;
        this.productScale = productScale;
        this.productVendor = productVendor;
        this.productDescription = productDescription;
        this.quantityInStock = quantityInStock;
        this.buyPrice = buyPrice;
        this.MSRP = MSRP;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productLine='" + productLine + '\'' +
                '}';
    }
}
