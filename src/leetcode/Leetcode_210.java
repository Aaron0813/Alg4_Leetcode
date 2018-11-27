/*
https://leetcode.com/problems/course-schedule-ii/description/
这题第一次写的相当不好,过两天要再写一次
*/
/*
ArrayDequeue 是什么--双向队列,可以支持在队列的头或者尾进行添加或者删除操作
*/

/**
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] adjacent_matrics = new int[numCourses][numCourses];
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < prerequisites.length; i++){
            int row = prerequisites[i][0];
            int col = prerequisites[i][1];
            adjacent_matrics[row][col] = 1;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] result = new int[numCourses];
        int index = 0;
        boolean is_ingree_zero = true;
        // queue.offer(Integer.MIN_VALUE);
        while(true){
            
            for(int i = 0; i < numCourses; i++){// col
                is_ingree_zero = true;
                for(int j = 0; j < numCourses; j++){// row
                    if(adjacent_matrics[j][i] == 1){
                        is_ingree_zero = false;
                        break;
                    }
                }
                System.out.println("break");
                if(is_ingree_zero == true && !set.contains(i)){
                    System.out.println("get In");
                    queue.offer(i);
                    set.add(i);
                    for(int j = 0; j < numCourses; j++){// col
                        adjacent_matrics[i][j] = 0;
                    }
                    Integer temp = queue.poll();
                    if(temp != null){
                        result[index++] = temp;
                    }
                }
            }
            if(is_ingree_zero == false){
                break;
            }
        }
        System.out.println(index);
        if(index < numCourses){
            return new int[1];
        }
        return result;

        
    }
}
*/

/** Passed*/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ingrees = new int[numCourses];
        List<List<Integer>> adjacent_list = new ArrayList<>(numCourses);
        init(ingrees, adjacent_list, prerequisites);       
        return greedy(ingrees, adjacent_list);
    }
    
    private void init(int[] ingrees, List<List<Integer>> adjacent_list, int[][] prerequisites){
        int length = ingrees.length;
        while(length-- > 0) adjacent_list.add(new ArrayList<>());
        for(int[] edge : prerequisites){
            ingrees[edge[0]]++;
            adjacent_list.get(edge[1]).add(edge[0]);
        }
    }
    
    private int[] greedy(int[] ingrees, List<List<Integer>> adjacent_list){
        Queue<Integer> queue = new ArrayDeque<>();
        int[] result = new int[ingrees.length];        
        for(int i = 0; i < ingrees.length; i++){
            if(ingrees[i] == 0) queue.offer(i);
        }
        int index = 0;
        while(queue.size() > 0){
            int node = queue.poll();
            result[index++] = node;
            for(int temp : adjacent_list.get(node)){
                ingrees[temp]--;
                if(ingrees[temp] == 0) queue.offer(temp);            
            }
        }
        //是new int[0] 还是 new int[1] 影响很大,因为new int的时候会将数组默认初始化为0;如果选择初始化为1,则其实数组里面是有一个0元素的,
        //这样子就会得到一个错误的答案      
        return index==ingrees.length?result:new int[0];
        
    }
}

/**/
