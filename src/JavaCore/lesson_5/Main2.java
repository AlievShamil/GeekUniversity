package JavaCore.lesson_5;

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        final int SIZE = 10000000;
        final int THREADS_COUNT = 3;
        final int PART_SIZE = SIZE / THREADS_COUNT;
        float[] mas = new float[SIZE];
        Arrays.fill(mas, 1f);
        long a = System.currentTimeMillis();
        float[][] m = new float[THREADS_COUNT][PART_SIZE];
        Thread[] t = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            System.arraycopy(mas, PART_SIZE * i, m[i], 0, PART_SIZE);
            final int u = i;
            t[i] = new Thread(() -> {
                for (int j = 0, z = u * PART_SIZE; j < PART_SIZE; j++, z++) {
                    m[u][j] = (float) (m[u][j] * Math.sin(0.2f + z / 5) * Math.cos(0.2f + z / 5) * Math.cos(0.4f + z / 2));
                }
            });
            t[i].start();
        }
        try {
            for (int i = 0; i < THREADS_COUNT; i++) {
                t[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < THREADS_COUNT; i++) {
            System.arraycopy(m[i], 0, mas, i * PART_SIZE, PART_SIZE);
        }
        System.out.println(System.currentTimeMillis() - a);
    }
}
