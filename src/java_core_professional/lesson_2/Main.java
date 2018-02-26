package java_core_professional.lesson_2;

public class Main {
    public static void main(String[] args) {
        try(SQLite sqLite = new SQLite()) {
            sqLite.connect();
            sqLite.createTable();
            sqLite.insert();
            sqLite.getPrice();
            sqLite.update();
            sqLite.getGoods();
        } catch (SQLite.GoodNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
