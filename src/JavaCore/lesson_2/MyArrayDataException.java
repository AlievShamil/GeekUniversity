package JavaCore.lesson_2;

import static java.lang.String.format;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(int x, int y) {
        System.err.println(getClass().getCanonicalName());
        System.out.println(format("В ячейке [%s][%s] лежат неверные данные!",x,y));
    }
}
