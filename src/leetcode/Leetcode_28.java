package leetcode;

/**
 * Author:   Fan(Aaron) Hu
 * Date:     2018/8/19 14:31
 * Description: Implement strStr()
 * https://leetcode.com/problems/implement-strstr/description/
 */
public class Leetcode_28 {
    public int strStr(String haystack, String needle) {
        // if(needle.equals("")||needle==null)
        //     return 0;
        // if(haystack!=null)
        //     return haystack.indexOf(needle);
        // else
        //     return 0;
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }

    }
}
