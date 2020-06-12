package june;

/**
 * @auther Muse47
 * 创建时间： 2019/6/14 11:06
 * 描述：
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;


    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {

    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public int getSize() {
        return  bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}