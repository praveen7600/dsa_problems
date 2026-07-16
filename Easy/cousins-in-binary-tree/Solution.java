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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            HashSet<Integer> set=new HashSet<>();
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                TreeNode leftNode=cur.left;
                TreeNode rightNode=cur.right;
                if(leftNode!=null && rightNode!=null && ((leftNode.val==x && rightNode.val==y) ||rightNode.val==x && leftNode.val==y)){
                    return false;
                }
                if(leftNode!=null){
                    queue.offer(cur.left);
                    set.add(leftNode.val);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                    set.add(rightNode.val);
                }
            }
            if(set.contains(x) && set.contains(y)){
                return true;
            }
        }
        return false;
    }
}