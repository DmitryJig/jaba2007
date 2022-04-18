package course2.homework7.server;

import course2.homework7.constants.Constants;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Logik for server
 */
public class MyServer {

    // сервис аутентификации
    private AuthService authService;

    // только АКТИВНЫЕ клиенты
    private List<ClientHandler> clients;

    public AuthService getAuthService() {
        return authService;
    }

    public MyServer() {
        try (ServerSocket server = new ServerSocket(Constants.SERVER_PORT)) {
            authService = new BaseAuthService();
            authService.start();

            clients = new ArrayList<>();

            while (true) {
                System.out.println("Сервер ожидает подключения");
                Socket socket = server.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(this, socket);
            }


        } catch (IOException e) {
            System.out.println("Ошибка в работе сервера");
            e.printStackTrace();
        } finally {
            if (authService != null) {
                authService.stop();
            }
        }
    }

    public synchronized void broadcastMessage(String message) {
        clients.forEach(client -> client.sendMessage(message));
//        for (ClientHandler client: clients) {
//            client.sendMessage(message);
//        }
    }

    public void sendMessageForOneClient(String message, String senderName) {

        String[] arr = message.split("\\s+"); // разбиваем сообщение по пробелам
        String receiverName = arr[1]; // берем имя получателя
        message = Arrays.stream(arr).skip(2).collect(Collectors.joining()); // выкидываем из массива команду и имя получателя и объединяем обратно в строку
        message = "Private message from " + senderName + ": " + message; // делаем красиво
        for (ClientHandler client : clients) {
            if (client.getName().equals(receiverName)) {
                client.sendMessage(message); // находим получателя и шлем ему сообщение
            }
        }
    }

    public synchronized void subscribe(ClientHandler client) {
        clients.add(client);
    }

    public synchronized void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

    public synchronized String getActiveClients() {
        StringBuilder sb = new StringBuilder(Constants.CLIENT_LIST_COMMAND).append(" ");

        sb.append(
                clients.stream()
                .map(c -> c.getName())
                .collect(Collectors.joining(" "))
        );
//        for (ClientHandler clientHandler : clients) {
//            sb.append(clientHandler.getName()).append(" ");
//        }
        return sb.toString();
    }
}
