package baseEntities;

import core.DataBaseService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseDBTest {
    protected DataBaseService dbService;

    @BeforeTest
    public void setupDBConnection() {
        dbService = new DataBaseService();
    }

    @AfterTest
    public void closeDBConnection() {
        dbService.closeConnection();
    }
}
