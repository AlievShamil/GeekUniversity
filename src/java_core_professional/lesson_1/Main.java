package java_core_professional.lesson_1;

import com.sun.istack.internal.NotNull;
import java_core_professional.lesson_1.big_task.Apple;
import java_core_professional.lesson_1.big_task.Box;
import java_core_professional.lesson_1.big_task.Fruit;
import java_core_professional.lesson_1.big_task.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>(new Apple(), new Apple(), new Apple());
        Box<Orange> orangeBox = new Box<>(new Orange(), new Orange());
        Box<Fruit> fruitBox = new Box<>(new Apple(), new Orange(), new Apple());
    }

    // 1.1
    private static <T> void swapElements1(@NotNull T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 1.2
    private static void swapElements2(@NotNull Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 2
    private static <T> ArrayList<T> transformer(@NotNull T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }
}
