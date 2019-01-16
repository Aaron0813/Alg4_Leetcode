/*
https://leetcode.com/problems/binary-tree-paths/
FB的一面题目,虽然很简单,但是现在重新写又感觉有点小麻烦,贴一下自己的两次提交,思路不一样

对我来说这题最麻烦的甚至可以说是要把"->"打印出来,这个真的是很烦
*/
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null){
            return res;
        }
        if(root.left == null && root.right == null){
            res.add("" + root.val);
            return res;
        }
        List<String> leftPath = binaryTreePaths(root.left);
        List<String> rightPath = binaryTreePaths(root.right);
        for(String l : leftPath){
            //有毒哇,这句居然没有多加root.val???
            //傻逼了, 如果leftPath确实有两条路径,那就是要加两次,leftPath里面存储的是完整的局部解->即String 路径,而不是节点信息
            res.add(root.val + "->" + l);
        }     
        for(String r : rightPath){
            res.add(root.val + "->" + r);
        }
        return res;
    }
}


class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null){
            return res;
        }
        List<List<String>> temp = new ArrayList<>(); 
        helper(root, new ArrayList<String>(), temp);
        for(List<String> r : temp){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < r.size(); i++){
                sb.append(r.get(i));
                if(i != r.size() - 1){
                    sb.append("->");
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
    
    private void helper(TreeNode node, List<String> current, List<List<String>> temp){
        if(node.left == null && node.right == null){
            current.add(String.valueOf(node.val));
            temp.add(current);
            return;
        }
        current.add(String.valueOf(node.val));
        if(node.left != null){
            helper(node.left, new ArrayList<String>(current), temp);   
        }
        if(node.right != null){
            helper(node.right, new ArrayList<String>(current), temp); 
        }
    }
}
