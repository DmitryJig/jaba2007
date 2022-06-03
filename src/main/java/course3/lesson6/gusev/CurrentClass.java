package course3.lesson6.gusev;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Logging
 */
public class CurrentClass {

    // log levels
    // Fatal > Error> Warn > Info> Debag> Trace (6 levels)
    // 6 > 5 > 4 >... >1
    public static void main(String[] args) {

        int longLevel = 3; // Info

        int a = 50;
        if (longLevel <= 2) { // Debug
            System.out.println(System.currentTimeMillis() + "our method: a= " + a);
        }
        int b = 10;
        if (longLevel <= 2) { // Debug
            System.out.println(System.currentTimeMillis() + "our method: b= " + b);
        }
        int c = a + b;
        if (longLevel <= 3) { // Info
            System.out.println(System.currentTimeMillis() + "our method: c= " + c);
        }

        // Logger, Appender, Layout
        //Логер это класс который занимается логированием сообщений
        // У одного логгера может быть несколько аппендеров, аппендер это дозапись в хвост
        Logger logger = LogManager.getLogger(CurrentClass.class.getName());

        logger.trace("Trace");
        logger.debug("Debug");
        logger.info("Info");
        logger.warn("Warn");
        logger.error("Error");
        logger.fatal("Fatal");
    }
}
