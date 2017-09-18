package JavaCore.lesson_7.server;

public interface AuthService {
    void start();
    String getNickByLogin(String login, String pass);
    void stop();
}
