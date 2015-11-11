package Google;
import java.util.*;

//longest increasing path on a binary tree  Leetcode 298
public class Num5 {
    public class TreeNode{
        TreeNode left,right;
        int val;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    
    public int longest = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        lc(root);
        return longest;
    }
    
    public int lc(TreeNode node) {
        if (node == null)
            return 0;
            
        int left = lc(node.left);
        int right = lc(node.right);
        int res = 1;
        if (left != 0 && node.val == node.left.val - 1)
            res = Math.max(res, left + 1);
        if (right != 0 && node.val == node.right.val - 1)
            res = Math.max(res, right + 1);
        longest = Math.max(res, longest);
        return res;
    }
}
