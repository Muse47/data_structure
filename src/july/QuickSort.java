package july;

import java.util.ArrayList;

/**
 * @auther Muse47
 * 创建时间： 2019/7/8 21:35
 * 描述：
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {5, 4, 6, 8, 9, 11};
        int n = a.length;

        long startTime = System.nanoTime();
        
        quickSort(a,0,5);

        long endTime = System.nanoTime();

        myprint(a);

        System.out.println("time:" + (endTime - startTime));

        System.out.println(a[0]+1);
    }

    public static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            //在[L,R]中随机一个数与数组最后一个数交换，为的是用该数作为标准进行partition操作
            // [...<x...=x...>x...X]分成2分继续递归，[...<x...] [...>x...]
            //最后再将X归位到=x中
            swap(arr, (int) (L + (Math.random() * (R - L + 1))), R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);//p[]保存的是arr数组下标，并不是arr数组在那个下标的值
            quickSort(arr, p[1] + 1, R);
        }
    }

    public static int[] partition(int[] arr, int L, int R) {
        //partition函数这里是以arr[R]为参照分别判断是大于他还是小于他还是等于他，最后R位置的值需要插回等于他的区间里
        int less = L - 1;//这里有三个指针，分别是less（小于arr[R]的最后一个值下标）more（大于arr[R]倒叙的最后一个下标，L（判断到的位置的下标））
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        //此方法是将数组最后一个数当做操作的那个数，因此排完序需要将他归位至more下标处，此时的more为大于操作数的第一个下标
        swap(arr,more,R);
        //返回=x的第一个下标+1和最后一个下标，x只有一个值，那么less+1=more。
        return new int[]{less + 1, more};
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

//    public void partition(int[] arr, int L, int R) {
//        int less = L - 1;
//        int more = R;
//        while (L < more) {
//            if (arr[L] < arr[R]) {
//                swap(arr, ++less, L++);
//            }
//            if (arr[L] > arr[R]) {
//                swap(arr, --more, L);
//            } else {
//                L++;
//            }
//        }
//    }
}