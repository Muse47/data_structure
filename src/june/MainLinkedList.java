package june;

/**
 * @auther Muse47
 * 创建时间： 2019/6/12 14:32
 * 描述：
 */
public class MainLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
        }
        System.out.println(linkedList);

    }
}