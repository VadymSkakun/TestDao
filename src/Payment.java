import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Payments")
public class Payment {
    @DatabaseField(id = true)
    int customerNumber;
    String checkNumber;
    String paymentDate;
    @DatabaseField
    double amount;

    Payment() {}

    public Payment(int customerNumber, String checkNumber, String paymentDate, double amount) {
        this.customerNumber = customerNumber;
        this.checkNumber = checkNumber;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "customerNumber=" + customerNumber +
                ", amount=" + amount +
                '}';
    }
}
