class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode prev = null;
        TreeNode current = root;
        TreeNode first = null;
        TreeNode second = null;
        while (current != null) {
            if (current.left != null) {
                TreeNode temp = current.left;
                while (temp.right != null && temp.right != current) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = current;
                    current = current.left;
                } else {
                    temp.right = null;
                    if (prev != null && prev.val > current.val) {
                        if (first == null) {
                            first = prev;
                        }
                        second = current;
                    }
                    prev = current;
                     current = current.right;
                }
            } else {
                if (prev != null && prev.val > current.val) {
                    if (first == null) {
                        first = prev;
                    }
                    second = current;
                }
                prev = current;
                current = current.right;
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
