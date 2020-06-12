package july;

import java.util.ArrayList;
import java.util.Currency;

/**
 * @auther Muse47
 * 创建时间： 2019/7/6 19:29
 * 描述：
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] a = {5, 2, 6, 8, 9, 1};
        int n = a.length;

        long startTime = System.nanoTime();
//        if (n <= 1) return;
//        for (int i = 1; i < n; ++i) {
//            int value = a[i];
//            int j = i - 1;
//// 查找插入的位置
//            for (; j >= 0; --j) {
//                if (a[j] > value) {
//                    a[j+1] = a[j]; // 数据移动
//                } else {
//                    break;
//                }
//            }
//            a[j+1] = value; // 插入数据
//        }

        if (a == null || n < 2) {
            return;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0 && a[j] > a[j + 1]; j--) {
                swap(a, j, j+1);
            }
        }

        long endTime = System.nanoTime();

        System.out.println("运行时间为:" + (endTime - startTime));

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