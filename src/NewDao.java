import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

public class NewDao {
    public static void main(String[] args) throws SQLException {
        String login = "user1";
        String pass = "pass1";
        String dataBaseURL = "jdbc:mysql://localhost/classicmodels?" + "user=" + login + "&password=" + pass;
        ConnectionSource connectionSource = new JdbcConnectionSource(dataBaseURL);
        Dao<Product, String> productStringDao = DaoManager.createDao(connectionSource, Product.class);

        QueryBuilder<Product, String> productQb = productStringDao.queryBuilder();
            List<Product> shipList =  productQb.where().eq("ProductLine", "Ships").query();
        for (Product list: shipList) {
            System.out.println(list);
        }

        Dao<Customer, Integer> customersDao = DaoManager.createDao(connectionSource, Customer.class);
        QueryBuilder<Customer, Integer> customerQb = customersDao.queryBuilder();

        Dao<Payment, Integer> paymentsDao = DaoManager.createDao(connectionSource, Payment.class);
        QueryBuilder<Payment, Integer> paymentQb = paymentsDao.queryBuilder();

        customerQb.where().eq("Country", "France");
        List<Payment> paymentList = paymentQb.join("CustomerNumber", "CustomerNumber", customerQb).orderBy("CustomerNumber", true).query();
        for (Payment paym: paymentList) {
            System.out.println(paym);
        }


    }
}
