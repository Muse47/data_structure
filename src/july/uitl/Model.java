package july.uitl;

import java.util.ArrayList;

/**
 * @auther Muse47
 * 创建时间： 2019/7/8 21:58
 * 描述：
 */
public class Model {

    public static void main(String[] args) {
        int[] a = {5, 2, 6, 8, 9, 1};
        int n = a.length;

        long startTime = System.nanoTime();



        long endTime = System.nanoTime();
        System.out.println("time:" + (endTime - startTime));
        myprint(a);
    }

    private static void myprint(int[] a) {
        ArrayList arr = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            arr.add(a[i]);
        }
        System.out.println(arr);
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
