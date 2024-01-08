package utils;

import org.apache.log4j.Logger;
import steps.StepDefinitions;

public class AssertUtils {

    private static Logger log = Logger.getLogger(AssertUtils.class);

    public static void assertAll(AssertInterface... assertions) {
        String assertionMessages = "";
        for (AssertInterface myAssert : assertions) {
            try {
                myAssert.assertThat();
            } catch (AssertionError e) {
                log.error(e.getMessage());
                StepDefinitions.saveScreenShot();
                assertionMessages+=e.getMessage();
            }
        }
        if (!assertionMessages.isEmpty()) {
            throw new AssertionError(assertionMessages);
        }
    }
}
