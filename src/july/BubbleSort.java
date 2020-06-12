package july;

import java.util.ArrayList;

/**
 * @auther Muse47
 * 创建时间： 2019/7/6 19:40
 * 描述：
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {5, 2, 6, 8, 9, 1};
        int n = a.length;

        long startTime = System.nanoTime();
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i-1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j+1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        long endTime = System.nanoTime();

        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < n; i++) {
            arrayList.add(a[i]);
        }
        System.out.println(arrayList);
        System.out.println("time:" + (endTime - startTime));
    }
}