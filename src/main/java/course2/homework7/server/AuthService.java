package course2.homework7.server;

import java.awt.desktop.OpenFilesEvent;
import java.util.Optional;

/**
 * Сервис аутентификации
 */
public interface AuthService {
    /**
     * Запустить сервис
     */
    void start();

    /**
     * Отключить сервис
     */
    void stop();

    /**
     * get nickname from logan and password
     * @param login
     * @param pass
     * @return nickname if client found or null if not found
     */
    Optional<String> getNickByLoginAndPass(String login, String pass);
}
