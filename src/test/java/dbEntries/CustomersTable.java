package dbEntries;

import core.DataBaseService;
import models.SimpleCustomer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;

public class CustomersTable {
    static Logger logger = LogManager.getLogger(CustomersTable.class);

    private DataBaseService dbService;

    public CustomersTable(DataBaseService dbService) {
        this.dbService = dbService;
    }

    public void createTable() {
        logger.info("Creating table");

        String createTableSQL = "CREATE TABLE public.customers (" +
                "id SERIAL PRIMARY KEY, " +
                "firstname CHARACTER VARYING(30), " +
                "lastname CHARACTER VARYING(30), " +
                "email CHARACTER VARYING(30), " +
                "age INTEGER" +
                ");";

        dbService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Dropping table");
        String sql = "DROP TABLE IF EXISTS customers;";

        dbService.executeSQL(sql);
    }

    public void addCustomer(SimpleCustomer customer) {
        String insertSql = "INSERT INTO public.customers(" +
                "firstname, lastname, email, age) " +
                "VALUES ('" + customer.getFirstname() + "', '" + customer.getLastname() + "', '" + customer.getEmail() + "', " + customer.getAge() + ");";

        dbService.executeSQL(insertSql);
    }

    public void updateCustomer(SimpleCustomer customer) {
    }

    public void deleteCustomer(SimpleCustomer customer) {
    }

    public ResultSet getAllCustomers() {
        String sql = "SELECT * FROM public.customers;";

        return DataBaseService.executeQuery(sql);
    }

    public ResultSet getById(int id) {
        String sql = "SELECT * FROM public.customers WHERE id = " + id + ";";

        return DataBaseService.executeQuery(sql);
    }
}
