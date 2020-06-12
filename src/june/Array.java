package june;

import com.sun.org.apache.xpath.internal.operations.Equals;
import org.omg.CORBA.Object;

/**
 * @auther Muse47
 * 创建时间： 2019/6/11 11:09
 * 描述：自定义数组方法
 */
public class Array<E> {
    private E[] data;
    //size:已插入数组长度
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacty() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        add(0,e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size-1);
    }

    //删除数组中的e元素
    public void removeElement(E e) {
        if (contains(e)) {
            remove(find(e));
        }
    }

    public void swap(int i, int j) {
        if (i < 0 || i > size || j < 0 || j > size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    //在index位置插入新元素e
    public void add(int index, E e) {
        if (size == data.length) {
            resize(data.length*2);
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.Array is full.");
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        E ret = data[index];
        for (int i = index; i < size-1; i++) {
            data[i] = data[i+1];
        }
        size--;
        //让size指向的对象为空，释放内存
        data[size] = null;
        return ret;
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    public void set(int index,E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        boolean flag = false;
        for (E element : data) {
            if (element.equals(e)) {
                flag = true;
            }
        }
        return flag;
    }

    public int find(E e) {
        int i = 0;
        for (E element : data) {
            if (element.equals(e)) {
                return i;
            }
            i++;
        }
        //如果不存在，返回-1
        return -1;
    }

    //数组自动扩容
    public void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString(){
        StringBuffer res = new StringBuffer();
        res.append(String.format("Array:size = %d , capacity = %d \n",size,data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size-1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}