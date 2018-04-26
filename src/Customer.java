import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Customers")
public class Customer {
    @DatabaseField(id = true)
    int customerNumber;
    @DatabaseField
    String customerName;
    String contactLastName;
    String contactFirstName;
    String phone;
    String addressLine1;
    String addressLine2;
    String city;
    String state;
    String postalCode;
    @DatabaseField
    String country;
    int salesRepEmployeeNumber;
    double creditLimit;

    Customer() {}

    public Customer(int customerNumber, String customerName, String contactLastName, String contactFirstName,
                    String phone, String addressLine1, String addressLine2, String city, String state, String postalCode,
                    String country, int salesRepEmployeeNumber, double creditLimit) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.contactLastName = contactLastName;
        this.contactFirstName = contactFirstName;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerNumber=" + customerNumber +
                ", customerName='" + customerName + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}

