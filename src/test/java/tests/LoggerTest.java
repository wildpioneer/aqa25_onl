package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoggerTest {
    private Logger logger = LogManager.getLogger(LoggerTest.class);

    @Test
    public void logLevelTest() {
        logger.trace("Trace Message: ...");
        logger.debug("Debug Message: ...");
        logger.info("Info Message: ...");
        logger.warn("Warning Message: ...");
        logger.error("Error Message: ...");
        logger.fatal("Fatal Message: ...");
    }

    @Test
    public void manyLogsTest() {
        for (int i = 0; i < 100; i++) {
            logger.info("Info Message: ... " + i);
        }
    }
}
