package june;

import org.omg.CORBA.Object;

/**
 * @auther Muse47
 * 创建时间： 2019/6/11 20:10
 * 描述：
 */
public class LoopQueue<E>implements Queue<E> {
    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        //由于循环队列需要空出一个位置避免front==tail判断为空，因此容量需要+1
        data = (E[]) new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail+1)%data.length;
        size++;
    }


    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("循环队列为空，无法出队");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("循环队列为空，无法出队");
        }
        return data[front];
    }

    //对比resize和toString两种不同的数组遍历方式
    public void resize(int newcapacity) {
        E[] newData = (E[]) new Object[newcapacity+1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString(){
        StringBuffer res = new StringBuffer();
        res.append(String.format("Queue:size = %d , capacity = %d \n",size,getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length!=tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

}