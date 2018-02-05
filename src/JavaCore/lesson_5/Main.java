package JavaCore.lesson_5;

import java.util.Arrays;

public class Main {
    private final static int SIZE = 10000000;

    public static void main(String[] args) {
        wholeArray();
        dividedArray();
    }

    private static void wholeArray() {
        float[] array = new float[SIZE];
        Arrays.fill(array, 1);
        long startTime = System.currentTimeMillis();
        calculate(array, 0);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    private static void dividedArray(){
        float[] array = new float[SIZE];
        Arrays.fill(array,1f);
        int half = SIZE/2;

        long startTime = System.currentTimeMillis();
        float[] firstHalf = new float[half];
        float[] secondHalf = new float[half];

        System.arraycopy(array, 0, firstHalf, 0, half);
        System.arraycopy(array, half, secondHalf, 0, half);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run(){
                calculate(firstHalf, 0);
            }
        });
        Thread thread2 = new Thread(() -> calculate(secondHalf, half));
        thread1.start();
        thread2.start();
        try{
            thread1.join();
            thread2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.arraycopy(firstHalf,0,array,0,half);
        System.arraycopy(secondHalf, 0, array, half, half);

        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    private static void calculate(float[] array, int offset) {
        for (int i = 0; i < array.length; i++) {
            int j = offset + 1;
            array[i] = (float) (array[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
        }
    }
}
