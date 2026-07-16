/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public void helper(TreeNode root,int targetSum,List<Integer> currentpath,int sum,List<List<Integer>> paths){
        if(root==null){
            return;
        }
        sum+=root.val;
        currentpath.add(root.val);
        System.out.println("Node "+root.val+" Sum=" +sum);
        
        if(root.left==null && root.right==null && targetSum==sum){
            
            paths.add(new ArrayList<>(currentpath));
        }
        helper(root.left,targetSum,currentpath,sum,paths);
        helper(root.right,targetSum,currentpath,sum,paths);
        
        currentpath.remove(currentpath.size()-1);


    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths=new ArrayList<>();
        List<Integer> currentpath=new ArrayList<>();
        helper(root,targetSum,currentpath,0,paths);
        return paths;
    }
}