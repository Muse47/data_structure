package august;

import java.util.*;

/**
 * @auther Muse47
 * 创建时间： 2019/8/8 0:21
 * 描述：
 */

class Solution {

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

/*    public static void main(String[] args) {
         String a ="cba";
         String b = "ab";
        findAnagrams(a, b);

    }*/
}
