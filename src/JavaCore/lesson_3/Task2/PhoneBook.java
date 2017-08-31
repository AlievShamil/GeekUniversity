package JavaCore.lesson_3.Task2;

import java.util.*;

import static java.lang.String.format;


public class PhoneBook {
    private Map<Integer, String> contacts;

    public PhoneBook() {
      contacts =  new HashMap<>();
    }

    public void add(int number, String surname) {
        if (!contacts.containsKey(number)) {
            contacts.put(number, surname);
        }
    }

    public void get(String surname) {
        Iterator<Map.Entry<Integer, String>> iter = contacts.entrySet().iterator();
        System.out.println(format("По запросу \'%s\' найдено:",surname));
        while (iter.hasNext()) {
            Map.Entry<Integer, String> pair = iter.next();
            if (pair.getValue().equals(surname))
                System.out.println(pair.getKey());
        }
    }
}
