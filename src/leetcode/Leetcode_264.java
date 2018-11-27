/*
 *https://leetcode.com/problems/ugly-number-ii/description/
 注意要通过一个HashSet来进行过滤
 */
class Solution {
    public int nthUglyNumber(int n) {
        int index = 1;
        Queue<Long> queue = new PriorityQueue<Long>();
        Set<Long> set = new HashSet<Long>();
        Long[] prime = new Long[3];
        prime[0] = Long.valueOf(2);
        prime[1] = Long.valueOf(3);
        prime[2] = Long.valueOf(5);
        Long num = Long.valueOf(1);
        for(int i = 0; i < 3; i++){
            queue.offer(prime[i]);
            set.add(prime[i]);
        }
        
        for(int i = 1; i < n; i++){
            num = queue.poll();
            for(int j = 0; j < 3; j++){
                if(!set.contains(num*prime[j])){
                    set.add(num*prime[j]);
                    queue.offer(num*prime[j]);
                }
            }
        }
        
        // return queue.peek().intValue();
        return num.intValue();//还是有点不能理解,为什么总感觉少了一次
    }
}
