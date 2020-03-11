package log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SpringLogTest {
    public static void main(String[] args) {
        Log log = LogFactory.getLog("spring");
        log.info("spring");
        System.out.println(log.toString());
    }
}
