import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

public class NewDao {
    public static void main(String[] args) {
        String login = "user1";
        String pass = "pass1";
        String dataBaseURL = "jdbc:mysql://localhost/classicmodels?" + "user=" + login + "&password=" + pass;

        ConnectionSource connectionSource = null;
        Dao<Product, String> productStringDao = null;
        try {
            connectionSource = new JdbcConnectionSource(dataBaseURL);
            productStringDao = DaoManager.createDao(connectionSource, Product.class);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        QueryBuilder<Product, String> productQb = productStringDao.queryBuilder();

        List<Product> shipList = null;
        try {
            shipList = productQb.where().eq("ProductLine", "Ships").query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Product list: shipList) {
            System.out.println(list);
        }

        Dao<Customer, Integer> customersDao = null;
        Dao<Payment, Integer> paymentsDao = null;
        try {
            customersDao = DaoManager.createDao(connectionSource, Customer.class);
            paymentsDao = DaoManager.createDao(connectionSource, Payment.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        QueryBuilder<Customer, Integer> customerQb = customersDao.queryBuilder();
        QueryBuilder<Payment, Integer> paymentQb = paymentsDao.queryBuilder();

        try {
            customerQb.where().eq("Country", "France");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Payment> paymentList = null;
        try {
            paymentList = paymentQb.join("CustomerNumber", "CustomerNumber", customerQb).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Payment paym: paymentList) {
            System.out.println(paym);
        }
    }
}
