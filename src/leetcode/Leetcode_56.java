package leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author Fan(Aaron) Hu
 * @Date 10/16/2018 1:10 PM
 * @Description Merge Intervals
 * https://leetcode.com/problems/merge-intervals/description/
 */

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class Leetcode_56 {
    static Comparator<Interval> c = new Comparator() {
        public int compare(Object a0, Object a1) {
            Interval s1 = (Interval) a0;
            Interval s2 = (Interval) a1;
            if (s1.start != s2.start) {
                return s1.start - s2.start;
            } else {
                return s1.end - s2.end;
            }
        }
    };

    public List<Interval> merge(List<Interval> intervals) {
        // boolean is_intersected = false;
        // how to get a list's length
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        Collections.sort(intervals, c);

        for (int i = 1; i < intervals.size(); ) {
            // if((i == intervals.size() && !is_intersected) || intervals.size() == 1){
            //     break;
            // }else if(is_intersected && i == intervals.size()){
            //     i--;
            // }
            Interval current = intervals.get(i - 1);
            Interval temp = intervals.get(i);
            if (current.start < temp.start) {
                if (current.end < temp.start) {
                    // no intersection
                    i++;
                    // is_intersected = false;
                } else {
                    current.start = Math.min(temp.start, current.start);
                    current.end = Math.max(temp.end, current.end);
                    intervals.remove(i);
                    // is_intersected = true;
                }
            } else {
                if (temp.end < current.start) {
                    // no intersection
                    i++;
                    // is_intersected = false;
                } else {
                    current.start = Math.min(temp.start, current.start);
                    current.end = Math.max(temp.end, current.end);
                    intervals.remove(i);
                    // is_intersected = true;
                }
            }
        }
        return intervals;
    }
}
