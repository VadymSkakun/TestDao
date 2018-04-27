import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

public class NewDao {

    static ConnectionSource connectionSource;

    private final static String login = "user1";
    private final static String pass = "pass1";
    static String dataBaseURL = "jdbc:mysql://localhost/classicmodels?" + "user=" + login + "&password=" + pass;

    static Dao<Product, String> productsDao;
    static Dao<Customer, Integer> customersDao;
    static Dao<Payment, Integer> paymentsDao;

    public static void main(String[] args) {
        try {
            connectionSource = new JdbcConnectionSource(dataBaseURL);
            productsDao = DaoManager.createDao(connectionSource, Product.class);

            QueryBuilder<Product, String> productQb = productsDao.queryBuilder();

            List<Product> shipList = productQb.where().eq("ProductLine", "Ships").query();

            for (Product list: shipList) {
                System.out.println(list);
            }

            customersDao = DaoManager.createDao(connectionSource, Customer.class);
            paymentsDao = DaoManager.createDao(connectionSource, Payment.class);

            QueryBuilder<Customer, Integer> customerQb = customersDao.queryBuilder();
            QueryBuilder<Payment, Integer> paymentQb = paymentsDao.queryBuilder();

            customerQb.where().eq("Country", "France");

            List<Payment> paymentList = paymentQb.join("CustomerNumber", "CustomerNumber", customerQb).query();

            for (Payment paym: paymentList) {
                System.out.println(paym);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
