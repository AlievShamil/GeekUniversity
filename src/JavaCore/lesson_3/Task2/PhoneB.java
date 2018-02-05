package JavaCore.lesson_3.Task2;


import java.util.ArrayList;
import java.util.HashMap;

public class PhoneB {
    private HashMap<String, ArrayList<String>> book;

    public PhoneB() {
        book = new HashMap<>();
    }

    public void add(String surname, String phone) {
        if(!book.containsKey(surname)) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(phone);
            book.put(surname,arrayList);
        } else book.get(surname).add(phone);
    }

    public ArrayList<String> get(String surname) {
        return book.get(surname);
    }
}
