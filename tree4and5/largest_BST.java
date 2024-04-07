class TreeNode {
    public int minNode, maxNode, maxSize;

    TreeNode(int mini, int maxi, int maxS) {
        this.minNode = mini;
        this.maxNode = maxi;
        this.maxSize = maxS;
    }
}

class Solution {
    public TreeNode helper(Node root) {
        if (root == null) {
            return new TreeNode((int)1e9, (int)-1e9, 0);
        }
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        if (left.maxNode < root.data && root.data < right.minNode) {
            return new TreeNode((Math.min(root.data, left.minNode)), (Math.max(root.data, right.maxNode)),
                    (1 + left.maxSize + right.maxSize));
        }
        return new TreeNode((int)-1e9, (int)1e9, Math.max(left.maxSize, right.maxSize));
    }

    int largestBst(Node root) {
        // Your code here

        return helper(root).maxSize;

    }
}
