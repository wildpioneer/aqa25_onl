package tests;

import org.testng.annotations.Test;

public class MavenTest {

    @Test
    public void mavenParamTest() {
        System.out.println(System.getProperty("suiteFileName"));
    }
}
