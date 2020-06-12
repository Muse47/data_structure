package july;

/**
 * @auther Muse47
 * 创建时间： 2019/7/13 17:33
 * 描述：
 */
//来自7.13的嘲讽，如果不会的话BAT一面第一题都过不了
public class Array_To_Stack_Queue {
    public static class ArrayStack {
        private Integer arr[];
        private Integer index;

        public void ArrayStack(int capacity) {
            if (capacity < 0) {
                throw new IllegalArgumentException("Capacity < 0 ");
            }
            arr = new Integer[capacity];
            index = 0; //index指针指的是栈中元素的下一个位置，不指向元素
        }

        public Integer peek() {
            return index > 0 ? arr[index] : null;
        }

        public void push(int num) {
            if (index == arr.length) {
                throw new IllegalArgumentException("Queue is full!");
            }
            arr[index++] = num;
        }

        public Integer pop() {
            if (index == 0) {
                throw new IllegalArgumentException("Queue is empty!");
            }
            return arr[--index];
        }

    }

    //忘记了看一次代码应该就记得了
    public static class ArrayQueue {
        private Integer arr[];
        private Integer size;
        private Integer first;
        private Integer last;

        public void ArrayQueue(int capacity) {
            if (capacity < 0) {
                throw new IllegalArgumentException("Capacity < 0!");
            }
            arr = new Integer[capacity];
            size = 0;
            first = 0;
            last = 0;
        }

        public Integer peek() {
            if (size == 0) {
                throw new IllegalArgumentException("Queue is empty!");
            }
            return arr[first];
        }

        public void push(int num) {
            if (size == arr.length) {
                throw new IllegalArgumentException("Queue is full!");
            }
            last = last == arr.length - 1 ? 0 : last;
            arr[last++] = num;
            size++;
        }

        public Integer pop() {
            if (size == 0) {
                throw new IllegalArgumentException("Queue is empty!");
            }
            size--;
            first = first == arr.length - 1 ? 0 : first;
            return arr[first++];
        }
    }


}