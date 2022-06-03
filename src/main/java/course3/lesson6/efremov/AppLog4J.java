package course3.lesson6.efremov;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
// уровни логирования
// FATAL - 100
// ERROR - 200
// WARN - 300
// INFO - 400
// DEBUG - 500
// TRACE - 600
// ALL - Integer.MAX_VALUE
public class AppLog4J {

    private static final Logger log = LogManager.getLogger(AppLog4J.class);

    public static void main(String[] args) {
        // такую конкатенацию лучше не использовать потому что при любом раскладе
        // компьютеру придется работать даже если уровень логирования выше
//        log.info("Program started " + Arrays.toString(args));
        // так лучше, если уровень вывода выше то компьютеру не придется в пустую складывать строки,
        // но преобразование Arrays.toString(args) все равно будет делаться
//        log.info("Program started {}", Arrays.toString(args));
        // лямбдой делаем операцию ленивой и если она не нужна она точно не будет выполняться
        log.info("Program started {}", () -> Arrays.toString(args));

    }
}
