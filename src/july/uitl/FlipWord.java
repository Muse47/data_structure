package july.uitl;



/**
 * @auther Muse47
 * 创建时间： 2019/7/10 12:11
 * 描述：
 */
public class FlipWord {
    public static void main(String[] args) {
        String str = "IchoosenottochooselifeIchoosesomethingelse.";
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            System.out.print(c);
        }
    }

//    public char[] flip(String strArray) {
//        char[] arr = strArray.toCharArray();
//        int mid = arr.length / 2;
//        int i = 0;
//        while (i < mid - 1) {
//            swap(arr, i, arr.length - 1 - i);
//        }
//        return arr;
//    }
//
//    public static void swap(char[] arr, int L, int R) {
//        char temp = arr[L];
//        arr[L] = arr[R];
//        arr[R] = temp;
//    }
}