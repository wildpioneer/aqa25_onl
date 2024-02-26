import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryTest {
    private int attempt = 1;

    @Test(retryAnalyzer = Retry.class)
    public void flakyTest() {
        if (attempt == 6) {
            Assert.assertTrue(true);
        } else {
            System.out.println("Attempt is: " + attempt);
            attempt++;
            throw new NullPointerException();
        }
    }
}
