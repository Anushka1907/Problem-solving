package tree1and2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class Level_order_traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new LinkedList<List<Integer>>();
        if(root==null) return ans;
        Queue<TreeNode> qu=new LinkedList<TreeNode>();
        qu.offer(root);
        while(!qu.isEmpty()){
            int size=qu.size();
            List<Integer> li=new LinkedList<>();
            for(int i=0;i<size;i++){
                if(qu.peek().left!=null) qu.offer(qu.peek().left);
                if(qu.peek().right!=null) qu.offer(qu.peek().right);
                li.add(qu.poll().val);
            }
            ans.add(li);
        }
        return ans;
    }
}
