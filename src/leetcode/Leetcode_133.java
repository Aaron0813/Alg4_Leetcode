/*
 *
 */

/*Fast Answer*/
public class Solution {
    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) return null;
        
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }
        return clone;
    }
}

/**
九章的算法
*/
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
        List<UndirectedGraphNode> new_nodes = getNodes(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        for(UndirectedGraphNode new_node : new_nodes){
            map.put(new_node, new UndirectedGraphNode(new_node.label));
        }
        
        for(UndirectedGraphNode new_node : new_nodes){
            for(UndirectedGraphNode neighbor : new_node.neighbors){
                map.get(new_node).neighbors.add(map.get(neighbor));
            }
        }
        
        return map.get(node);
    }
    
    private List<UndirectedGraphNode> getNodes(UndirectedGraphNode node){
        // List<UndirectedGraphNode> new_nodes = new ArrayList<UndirectedGraphNode>();
        Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        set.add(node);
        while(queue.size() > 0){
            UndirectedGraphNode temp = queue.poll();
            for(UndirectedGraphNode neighbor: temp.neighbors){
                if(!set.contains(neighbor)){
                    set.add(neighbor);
                    queue.offer(neighbor);
                }       
            }
            
        }
        return new ArrayList<UndirectedGraphNode>(set);
    }
}