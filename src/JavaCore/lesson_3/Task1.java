package JavaCore.lesson_3;

import java.util.*;

import static java.lang.String.format;

public class Task1 {

    public static void main(String[] args) {
        String[] words = {
                "Желание", "Ржавый", "Семнадцать", "Рассвет", "Печь", "Девять",
                "Добросердечный", "Возвращение на Родину", "Один", "Товарный вагон",
                "Желание", "Один", "Семнадцать", "Желание", "Добросердечный", "Девять",
                "Добросердечный", "Желание", "Один", "Товарный вагон",
        };

        List<String> arrList = Arrays.asList(words);

//        Set<String> set = new LinkedHashSet<>(arrList);
//        System.out.println("Список слов без дубликатом:\n");
//
//        for (String word : set) System.out.println(word);
//        System.out.println("----------------------------------------------");
//        for (String word : set) {
//           int repCount = Collections.frequency(arrList,word);
//            System.out.println(format("\'%s\' встречается - %s раз(а)",word,repCount));
//        }

        Map<String, Integer> map = addListToMap(arrList);

        System.out.println("Список слов без дубликатом:\n");
        for (String word : map.keySet()) {
            System.out.println(word);
        }
        System.out.println("----------------------------------------------");
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            String key = item.getKey();
            int value = item.getValue();
            System.out.println(format("\'%s\' встречается - %s раз(а)", key, value));
        }


    }

    public static Map<String, Integer> addListToMap(List<String> list) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String s : list) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        return map;
    }
}
