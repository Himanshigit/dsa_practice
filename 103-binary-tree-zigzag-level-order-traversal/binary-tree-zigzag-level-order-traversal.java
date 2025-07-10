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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        boolean ltor=true;
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            LinkedList<Integer> level = new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode current = q.poll();
                if(ltor){
                    level.addLast(current.val);
                }else{
                    level.addFirst(current.val);
                }
                if(current.left!=null) q.offer(current.left);
                if(current.right!=null) q.offer(current.right);

            }
            ltor=!ltor;
            result.add(level);
        }
        return result;
    }
}