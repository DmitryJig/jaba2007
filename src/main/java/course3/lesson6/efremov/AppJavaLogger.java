package course3.lesson6.efremov;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// настройки логгера указываем в файле в папке resources

// SEVERE > WARNING > INFO > CONFIG > FINE > FINEST > ALL, правые 4 чисто для дебага
// вообще лучше использовать log4j ver.2 or SLF4J
public class AppJavaLogger {
    private static final Logger log = Logger.getLogger(AppJavaLogger.class.getName());

    public static void main(String[] args) {
        log.setLevel(Level.FINEST); //можем задать уровень логи которого будем выводить
        try {
            final FileHandler fileHandler = new FileHandler("mylog.txt");
            fileHandler.setFormatter(new SimpleFormatter());
            log.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.log(Level.FINE, "Program started"); // уровень логирования Fine
        final AppJavaLogger app = new AppJavaLogger();
        app.m("abc", 4);
        log.fine("Program started"); // тоже самое
    }

    private void m(String a, int i){
        log.info("a = " + a + ", i = " + i); // минус в том что конкатенация произойдет даже если ничего в лог не выведется
        try {
            i/=0;
        } catch (Exception e){
            log.severe(e.getMessage());
        }
    }
}
