package lru_lfu;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description
 * @Author Simula47
 * @Date 2020/6/12 9:17
 */
public class LRU<k, v> extends LinkedHashMap<k, v> {

    private final int MAX_SIZE;

    public LRU(int capcity) {
        super(8, 0.75f,true);
        this.MAX_SIZE = capcity;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<k, v> eldest) {
        if (size() > MAX_SIZE) {
            System.out.println("移除的元素为：" + eldest.getValue());
        }
        return size() > MAX_SIZE;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new LRU<>(5);
        for (int i = 1; i <= 11; i++) {
            map.put(i, i);
            System.out.println("cache的容量为：" + map.size());
            if (i == 4) {
                map.get(1);
            }
        }

        System.out.println("=-=-=-=-=-=-=-map元素:");
        map.entrySet().forEach(integerIntegerEntry -> System.out.println(integerIntegerEntry.getValue()));

    }

}
