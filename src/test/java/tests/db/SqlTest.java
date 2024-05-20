package tests.db;

import baseEntities.BaseDBTest;
import core.DataBaseService;
import dbEntries.CustomersTable;
import models.Customer;
import models.SimpleCustomer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import services.db.CustomerService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SqlTest extends BaseDBTest {
    static Logger logger = LogManager.getLogger(SqlTest.class);

    @Test
    public void firstDBTest() {
        String sql = "SELECT * FROM public.customers;";

        ResultSet rs = DataBaseService.executeQuery(sql);

        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                int age = rs.getInt("age");

                logger.info("ID: " + id);
                logger.info("Firstname: " + firstname);
                logger.info("Lastname: " + lastname);
                logger.info("Email: " + email);
                logger.info("Age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        logger.info("Test is completed...");
    }

    @Test
    public void secondDBTest() {
        CustomersTable customersTable = new CustomersTable(dbService);

        // Это специфический пример для ознакомления
        customersTable.dropTable();
        customersTable.createTable();

        customersTable.addCustomer(new SimpleCustomer(1, "Иван", "Иванов", "ivan@test.com", 34));
        customersTable.addCustomer(new SimpleCustomer(1, "Петр", "Петров", "petr@test.com", 24));
        customersTable.addCustomer(new SimpleCustomer(1, "Марина", "Стасевич", "marina@test.com", 26));

        ResultSet rs = customersTable.getAllCustomers();

        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                int age = rs.getInt("age");

                logger.info("ID: " + id);
                logger.info("Firstname: " + firstname);
                logger.info("Lastname: " + lastname);
                logger.info("Email: " + email);
                logger.info("Age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        logger.info("Test is completed...");
    }

    @Test
    public void hibernateTest() {
        CustomerService customerService = new CustomerService();
        Customer customer = new Customer(1, "Ivan", "Grigoriev", "test@email.com", 28);
        customerService.saveUser(customer);

        List<Customer> customersList = customerService.findAllUsers();
        for (Customer cust : customersList) {
            logger.info(cust.toString());
        }
    }
}
