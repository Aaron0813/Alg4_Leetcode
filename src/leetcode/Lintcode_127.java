/*
https://www.lintcode.com/problem/topological-sorting
*/


/*My solution*/
/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        if(graph == null || graph.size() == 0){
            return null;
        }
        Map<DirectedGraphNode, Set<DirectedGraphNode>> map = buildTopoOrder(graph);
        Set<Map.Entry<DirectedGraphNode, Set<DirectedGraphNode>>> set = map.entrySet();      
        
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        ArrayList<DirectedGraphNode> topoOrder = new ArrayList<>();
        Set<DirectedGraphNode> isVisited = new HashSet<>();
        
        /*之前是判断map里面key所对应value的值是否为empty,但是发现这样子根本没办法获取入度为0的点,因为入度为0的点根本不会存在这个map里面*/
        for(DirectedGraphNode node : graph){
            if (!map.containsKey(node)) {
                queue.offer(node);
                System.out.println("node value = " + node.label);
            }
        }

        
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            topoOrder.add(node);
            isVisited.add(node);
            set = map.entrySet();
            for (DirectedGraphNode neigh : node.neighbors) {
                if(map.get(neigh).contains(node)){
                    map.get(neigh).remove(node);
                    if(map.get(neigh).isEmpty()){
                        queue.offer(neigh);
                    }
                }
            }

        }
        return topoOrder;
    }
    
    private Map<DirectedGraphNode, Set<DirectedGraphNode>> buildTopoOrder(ArrayList<DirectedGraphNode> graph){
        Map<DirectedGraphNode, Set<DirectedGraphNode>> map = new HashMap<>();
        if(graph == null || graph.size() == 0){
            return null;
        }
        Set<DirectedGraphNode> isVisited = new HashSet<>();
        for(DirectedGraphNode node : graph){
            for(DirectedGraphNode neighbor : node.neighbors){
                if(isVisited.contains(neighbor)){
                    map.get(neighbor).add(node);
                }else{
                    Set<DirectedGraphNode> set = new HashSet<>();
                    set.add(node);
                    map.put(neighbor, set);
                    // 一开始忘了加这句,导致整个程序都运行不起来.
                    /* 最近做图的遍历问题的时候,发现这个问题经常会犯,即忘了更新HashSet,导致一些不必要的重复访问等*/
                    isVisited.add(neighbor);
                }
            }
        }
        return map;

    }
}


/* 九章的算法*/
public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        HashMap<DirectedGraphNode, Integer> map = new HashMap();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1); 
                }
            }
        }
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                q.offer(node);
                result.add(node);
            }
        }
        while (!q.isEmpty()) {
            DirectedGraphNode node = q.poll();
            for (DirectedGraphNode n : node.neighbors) {
                map.put(n, map.get(n) - 1);
                if (map.get(n) == 0) {
                    result.add(n);
                    q.offer(n);
                }
            }
        }
        return result;
    }
