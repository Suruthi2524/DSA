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
    ArrayList<Integer> al = new ArrayList();/* without forcefully return the arraylist
     everytime store it out of the methodx*/
    public void preOrder(TreeNode root){
        if(root ==null) return ;
        al.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
      
    }
    public List<Integer> preorderTraversal(TreeNode root) {
       preOrder(root);
       return al;
    }
}