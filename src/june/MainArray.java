package june;

/**
 * @auther Muse47
 * 创建时间： 2019/6/11 12:58
 * 描述：
 */
public class MainArray {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        System.out.println("=============");

        array.addFirst(1024);
        array.addLast(512);
        System.out.println(array);
        System.out.println("=============");

        int getNum = array.get(0);
        System.out.println(getNum);
        System.out.println("=============");

        array.set(0,100);
        System.out.println(array);
        System.out.println("=============");

        System.out.println(array.contains(333));
        System.out.println("=============");

        System.out.println(array.find(1));
        System.out.println("=============");


        array.removeLast();
        System.out.println(array);
        System.out.println("=============");

        array.removeElement(1320);
        System.out.println(array);
        System.out.println("=============");
    }
}