package JavaCore.lesson_7.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server {
    private final int PORT = 8289;
    private Vector<ClientHandler> clients;
    private AuthService authService;
    private AuthService getAuthService(){
        return authService;
    }
    public Server(){
        ServerSocket server = null;
        Socket socket = null;
        authService = new BaseAuthService();
        authService.start();
        clients = new Vector<>();
        try{
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен, ждем клиентов");
            while(true){
                socket = server.accept(); //режим ожидания, возвращает объект типа сокет, блокирует выполнение кода
//                clients.add(new ClientHandler(socket, this));
                subscribeMe(new ClientHandler(socket, this));
                System.out.println("Клиент подключился");
            }
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Не удалось запустить сервер");
        }finally{
            try{
                socket.close();
                server.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    public synchronized boolean isNickBusy(String nick) {
        for (ClientHandler o : clients) {
            if (o.getName().equals(nick)) return true;
        }
        return false;
    }


    public synchronized void broadcast(String msg){
        for(ClientHandler c: clients){
            c.sendMessage(msg);
        }
    }
    public synchronized void subscribeMe(ClientHandler c){
        clients.add(c);
    }
    public synchronized void unsubscribeMe(ClientHandler c){
        clients.remove(c);
    }
}
