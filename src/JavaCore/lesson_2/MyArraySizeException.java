package JavaCore.lesson_2;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {

    public MyArraySizeException() {
        System.err.println(getClass().getCanonicalName());
        System.out.println("Размер массива задан неверно!");
    }
}
