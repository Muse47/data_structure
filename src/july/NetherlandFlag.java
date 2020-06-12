package july;

import java.util.ArrayList;

/**
 * @auther Muse47
 * 创建时间： 2019/7/8 20:58
 * 描述：
 */
public class NetherlandFlag {
    public static void main(String[] args) {
        int[] a = {5, 2, 6, 8, 9, 1, 3, 7, 4};
        int n = a.length;
        partition(a, 0, 8, 5);
        myprint(a);
    }

    public static int[] partition(int[] arr, int L, int R, int num) {
        int less = L - 1;
        int more = R + 1;
        int cur = L;
        while (cur < more) {
            if (arr[cur] < num) {
                swap(arr,++less,cur++);
            } else if (arr[cur] > num) {
                swap(arr, cur, --more);
            } else {
                cur++;
            }
        }
        return new int[]{less + 1, more - 1};
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