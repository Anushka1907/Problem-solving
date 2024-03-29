package tree3;

import javax.swing.tree.TreeNode;

public class diameter_of_the_tree {
    int diameter;
    public int help(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=help(root.left);
        int right=help(root.right);
        diameter=Math.max(diameter,left+right);
        return Math.max(left,right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        diameter=0;
        help(root);
        return diameter;
    }
}
