package course2.homework6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerApp {

    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private ServerSocket serverSocket;


    private void openConnection() throws IOException {

        serverSocket = new ServerSocket(8089);
        System.out.println("Сервер ожидает подключения... ");
        socket = serverSocket.accept(); //ждем подключение (Блокируемся как с джойном на потоке)
        System.out.println("Клиент подключился");

        dataInputStream = new DataInputStream(socket.getInputStream()); //берем входящий поток информации
        dataOutputStream = new DataOutputStream(socket.getOutputStream());

        try {
            while (true) {
                String message = dataInputStream.readUTF(); //тоже блокирующий метод, останавливаемся и ждем сообщение и пишем это в строку

                if ("/end".equals(message)) { //убиваем бесконечный цикл position pill

                    dataOutputStream.writeUTF(message);

                    System.out.println("Завершение работы сервера");
                    break;
                }
                System.out.println("Клиент прислал " + message);
            }
            System.out.println("Соединение на сервере разорвано");
            closeConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.nextLine();
            if (message.trim().isEmpty()) {
                return;
            }
            try {
                dataOutputStream.writeUTF(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void closeConnection() {
        try {
            dataOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dataInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();  //тут первым закрыл серверсокет, или надо было сокет?
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ServerApp echoServer = new ServerApp();

        Thread messageThread = new Thread(echoServer::sendMessage);
        messageThread.setDaemon(true); // чтобы закруглялся с основной программой
        messageThread.start();

        try {
            echoServer.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}