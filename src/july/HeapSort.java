package july;

import java.util.ArrayList;

/**
 * @auther Muse47
 * 创建时间： 2019/7/9 0:13
 * 描述：
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] a = {5, 2, 6, 8, 9, 1};
        int n = a.length;

        long startTime = System.nanoTime();

        heapSort(a);

        long endTime = System.nanoTime();
        System.out.println("time:" + (endTime - startTime));
        myprint(a);
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    //最大根堆尾插入一个数，向上找到他在堆中的位置
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //最大根堆头插入一个数，向下找到他在堆中的位置（或者随机位置数值变小）
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1]
                    ? left + 1
                    : left;
            largest = arr[largest] > arr[index]
                    ? largest
                    : index;
            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
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