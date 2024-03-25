package tree1and2;

import javax.swing.tree.TreeNode;

public class Same_tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if(p == null && q == null) return true;

        if(q == null || p == null) return false;
        if(p.val != q.val) return false;

        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }
}
