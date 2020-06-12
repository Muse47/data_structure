package june;

/**
 * @auther Muse47
 * 创建时间： 2019/6/20 11:57
 * 描述：
 */
public class SegmentTreeMain {
    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segTree = new SegmentTree<>(nums, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });
        System.out.println(segTree.query(0, 1));

    }

}