package Java_Level_02.Lesson_05;

public class Main_05 {
    static final int size = 10000000;
    static final int h = size / 2;
//    private static int[] arr;
    static float[] arr = new float[size];

    public static void main(String[] args) {
        calculationInOneThread();


        calculationInTwoThread();


    }

    private static void calculationInTwoThread() {
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        fillOne(arr);
        long b = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread(() -> fillByForm(a1, h));
        Thread t2 = new Thread(() -> fillByForm(a1, h));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println(System.currentTimeMillis() - b);
    }

    private static void calculationInOneThread() {
        fillOne(arr);
        long a = System.currentTimeMillis();
        fillByForm(arr, size);
        System.out.println(System.currentTimeMillis() - a);
    }

    private static void fillByForm(float[] arr, int size) {
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private static void fillOne(float[] arr) {
        for (int i = 0; i < size; i++) {
            arr[i] = 1f;
        }
    }
}
