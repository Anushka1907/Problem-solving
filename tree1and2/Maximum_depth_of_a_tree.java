package tree1and2;

import javax.swing.tree.TreeNode;

public class Maximum_depth_of_a_tree {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return 1+Math.max(left,right);
    }
}
