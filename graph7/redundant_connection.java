class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] size = new int[n+1];

        for(int i=0; i<= n; i++){
            parent[i] =i;
            size[i] = 1;
        }
        int i=0;
        for(; i< n; i++){
            int[] edge = edges[i];
            int u = edge[0];
            int v = edge[1];

            int ul = find(parent, u);
            int vl = find(parent, v);

            if(ul == vl) break;
            else{
                union(ul, vl, parent, size);
            }
        }
        return edges[i];
        
    }
    private int find(int[] parent, int i){
        if(parent[i] == i){
            return parent[i];
        }
        return parent[i] = find(parent, parent[i]);
    }

    private void union(int ul, int vl, int[] parent, int[] size){
        if(ul < vl){
            parent[ul] = vl;
            size[ul] += size[vl];
        }
        else{
            parent[vl] = ul;
            size[vl] += size[ul]; 
        }
    }
}