package july;

import java.util.ArrayList;

/**
 * @auther Muse47
 * 创建时间： 2019/7/7 23:46
 * 描述：
 */
public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr.length < 2 && arr == null) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int L, int R) {
        int mid = L + (R - L) / 2;
        if (L == R) {
            return;
        }
        //将两边排好序的数组进行排序
        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        //p1,p2是指针，L,R,mid不能作为指针
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int i = 0;
        //两边顺序数组进行按从小到大对比排序，当一个数组下标到达末尾则该数组插入辅助数组的使命完成
        while (p1 <= mid && p2 <= R) {
//            if (arr[p1] < arr[p2]) {
//                help[i++] = arr[p1++];
//            } else if (arr[p1] > arr[p2]) {
//                help[i++] = arr[p2++];
//            }
            help[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }
        //当一边数组使命完成后，判断是哪一边还未完成，并将未完成那边剩余的元素直接按原本顺序插入辅助数组
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        //将辅助数组复制回arr数组
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }
}