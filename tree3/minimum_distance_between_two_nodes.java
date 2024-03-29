class GfG {
    Node lowestCommonAncestor(Node root, int p, int q) {
        if(root==null || root.data==p || root.data==q){
            return root;
        }
        Node left=lowestCommonAncestor(root.left,p,q);
        Node right=lowestCommonAncestor(root.right,p,q);
        if(left==null){
            return right;
        }
        else if(right==null){
            return left;
        }
        else if(left!=null && right!=null){
            return root;
        }
        else{
            return null;
        } 
    }
    int height(Node ancestor,int n,int d){
        if(ancestor==null) return Integer.MAX_VALUE;
        if(ancestor.data==n) return d;
        return Math.min(height(ancestor.left,n,d+1),height(ancestor.right,n,d+1));
    }
    int findDist(Node root, int a, int b){
        Node ancestor=lowestCommonAncestor(root,a,b);
        int h1=height(ancestor,a,0);
        int h2=height(ancestor,b,0);
        return h1+h2;
    }
}
