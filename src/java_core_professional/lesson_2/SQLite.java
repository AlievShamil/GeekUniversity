package java_core_professional.lesson_2;
import java.sql.*;
import java.util.Scanner;

public class SQLite implements AutoCloseable {
    private Connection connection;
    private Statement statement;
    private PreparedStatement ps;
    private Scanner scanner = new Scanner(System.in);
    ;

    public void connect() throws ClassNotFoundException, SQLException {
        String className = "org.sqlite.JDBC";
        String url = "jdbc:sqlite:main.db";

        Class.forName(className);
        connection = DriverManager.getConnection(url);
        statement = connection.createStatement();

    }

    public void createTable() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS goods (" +
                "    id    INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    prodid  INTEGER,\n" +
                "    title  TEXT,\n" +
                "    cost INTEGER\n" +
                ");"
        );

    }

    public void insert() throws SQLException {
        String insertIntoGoods = "INSERT INTO goods (prodid, title, cost) VALUES (?, ?, ?);";
        String deleteFromGoods = "DELETE FROM goods";

        ps = connection.prepareStatement(insertIntoGoods);
        statement.executeUpdate(deleteFromGoods);
        connection.setAutoCommit(false);
        for (int i = 1; i <= 10000; i++) {
            ps.setInt(1, i);
            ps.setString(2, "товар" + i);
            ps.setInt(3, 10 * i);
            ps.addBatch();
        }
        ps.executeBatch();
        connection.setAutoCommit(true);
    }


    private void disconnect() {
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getPrice() throws SQLException {
        String key = "/цена";
        String sql = "SELECT cost FROM goods WHERE title = ?;";

        ps = connection.prepareStatement(sql);

        String inputStr = scanner.nextLine();
        String[] args = inputStr.split(" ");
        if (args.length != 2) {
            System.out.println("Неверный формат");
            return;
        }

        if (args[0].equalsIgnoreCase(key)) {
            ps.setString(1, args[1]);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if (!rs.isBeforeFirst()) {
                throw new GoodNotFoundException();
            }
            while (rs.next()) {
                System.out.println(rs.getInt(1));
            }
        }
    }

    public void getGoods() throws SQLException {
        String key = "/товарыпоцене";
        String sql = "SELECT title, cost FROM goods WHERE cost BETWEEN ? AND ?;";

        String inputStr = scanner.nextLine();
        String[] args = inputStr.split(" ");
        if (args.length != 3) {
            System.out.println("Неверный формат");
            return;
        }

        ps = connection.prepareStatement(sql);

        if (args[0].equalsIgnoreCase(key)) {
            ps.setString(1, args[1]);
            ps.setString(2, args[2]);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            if (!rs.isBeforeFirst()) {
                throw new GoodNotFoundException();
            }
            while (rs.next()) {
                System.out.println(rs.getString(1)+" цена: "+rs.getInt(2));
            }
        }
    }

    public void update() throws SQLException {
        String key = "/сменитьцену";
        String sql = "UPDATE goods SET cost = ? WHERE title = ?";

        String inputStr = scanner.nextLine();
        String[] args = inputStr.split(" ");
        if (args.length != 3) {
            System.out.println("Неверный формат");
            return;
        }
        ps = connection.prepareStatement(sql);
        if (args[0].equalsIgnoreCase(key)) {
            ps.setString(1, args[2]);
            ps.setString(2, args[1]);
            ps.executeUpdate();
        }
    }

    public void close() throws Exception {
        this.disconnect();
    }

    class GoodNotFoundException extends SQLException {
        public GoodNotFoundException() {
            super("Такого товара нет!");
        }
    }
}

