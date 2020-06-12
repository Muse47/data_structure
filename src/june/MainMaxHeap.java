package june;

import java.util.Random;

/**
 * @auther Muse47
 * 创建时间： 2019/6/17 16:34
 * 描述：
 */
public class MainMaxHeap {
    public static void main(String[] args) {

        int n = 1000000;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] < arr[i + 1]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test MaxHeap completed!");

    }
}