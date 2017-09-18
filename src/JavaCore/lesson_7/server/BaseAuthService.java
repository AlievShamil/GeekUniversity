package JavaCore.lesson_7.server;

import java.util.ArrayList;

public class BaseAuthService implements AuthService {

    private ArrayList<Entry> entries;


    @Override
    public void start() {

    }

    @Override
    public String getNickByLogin(String login, String pass) {
        for (Entry o : entries) {
            if (o.login.equals(login) && o.pass.equals(pass)) return o.nick;
        }
        return null;
    }

    @Override
    public void stop() {
    }


    private class Entry {
        private String login;
        private String pass;
        private String nick;

        public Entry(String login, String pass, String nick) {
            this.login = login;
            this.pass = pass;
            this.nick = nick;
        }
    }
}
