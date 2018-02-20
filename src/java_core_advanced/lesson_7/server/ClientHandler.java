package java_core_advanced.lesson_7.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Socket socket;
    private Server server;
    private DataOutputStream out;
    private DataInputStream in;
    private String name;

    public ClientHandler(Socket socket, Server server) {
        try {
            this.socket = socket;
            this.server = server;
            name="underfined";
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            try {
                //Авторизация
                while (true) {
                    String str = in.readUTF();
                    if (str.startsWith("/auth")) {
                        String[] elements = str.split(" ");
                        String nick = server.getAuthService().getNickByLogin(elements[1], elements[2]);
                        if (nick != null) {
                            if (server.isNickBusy(nick)) {
                                sendMessage("/authok" + nick);
                                this.name = nick;
                                server.broadcast(nick + " зашел в чат");
                                break;
                            } else sendMessage("Учатная запись используется");
                        } else sendMessage("Не верные логин/пароль");
                    } else sendMessage("Для начала нужно авторизоваться");
                } //конец авторизации
                while (true) {
                    String str = in.readUTF();
                    if (str.equalsIgnoreCase("/end")) break;
                    System.out.println("client: " + str);
//                        sendMessage("echo: " + str);
                    server.broadcast(this.name + str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                server.unsubscribeMe(this);
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void sendMessage(String msg) {
        try {
            out.writeUTF(msg);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }
}
