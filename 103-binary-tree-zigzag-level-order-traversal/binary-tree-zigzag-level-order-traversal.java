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
    static List<List<Integer>> res;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        res = new ArrayList<>();
        return solveLvl(root);
    }

    public static List<List<Integer>> solveLvl(TreeNode root){
        if(root == null)return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;

        while(!q.isEmpty()){
            int lvl = q.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < lvl; i++){
               TreeNode curr = q.poll();
               level.add(curr.val);

                if(curr.left != null)q.offer(curr.left);
                if(curr.right != null)q.offer(curr.right);
            }

            if(!leftToRight){
                Collections.reverse(level);
            }

            res.add(level);
            leftToRight = !leftToRight;
        }

        return res;
    }
}