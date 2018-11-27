/*
https://leetcode.com/problems/word-ladder/description/
*/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean is_exist = false;
        for(String word : wordList){
            if(word.equals(endWord)){
                is_exist = true;
                break;
            }
        }
        if(!is_exist){
            return 0;
        }
        
        Queue<List<String>> queue = new LinkedList<List<String>>();
        // Queue<List<List<String>>> queue = new LinkedList<List<List<String>>>();
        List<String> neighbour = new LinkedList<String>();
        queue.offer(new LinkedList(find_neighbour(beginWord, wordList)));
        int length = 1;
        
        while(queue.size() > 0){
            length++; 
            List<String> current_list = queue.poll();
            // if(current_list == null){
            //     return 0;
            // }
            List<String> next_nodes = new LinkedList<String>();
            for(String w : current_list){
                if(endWord.equals(w)){
                    return length;
                }else{
                    List<String> current_neighbour = new LinkedList<String>(find_neighbour(w, wordList));
                    for(String next_node : current_neighbour){
                        next_nodes.add(next_node);
                    }
                }
            }
            if(next_nodes.size() != 0)
                queue.offer(next_nodes);
                   
        }
        return 0;
    }
    
    private List<String> find_neighbour(String word, List<String> wordList){
        List<String> result = new LinkedList<String>();
        List<String> temp = new LinkedList<String>(wordList);
        for(String w : temp){
            if(get_distance(w, word) == 1){
                result.add(w);
                wordList.remove(w);//防止成环
            }
        }        
        return result;
    }
    
    private int get_distance(String s1, String s2){
        int distance = 0;
        for(int i = 0; i < s1.length(); i++){
            if(!(s1.charAt(i) == s2.charAt(i))){
                distance++;
            }
        }
        return distance;
    }
}
