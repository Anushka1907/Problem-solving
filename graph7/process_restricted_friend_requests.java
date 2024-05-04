class DSU{
    private int[] par,size;
    
    DSU(int n){
        par=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
            size[i]=0;
        }
    }
    
    public int findpar(int node){
        if(par[node]==node) return node;
        return par[node]=findpar(par[node]);
    }
    
    public void union(int u,int v){
        int pu=findpar(u);
        int pv=findpar(v);
        
        if(pu==pv) return;
        
        if(size[pu]<size[pv]){
            par[pu]=pv;
            size[pv]+=size[pu];
        }
        else{
            par[pv]=pu;
            size[pu]+=size[pv];
        }
    }
    
    
}
class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        DSU d=new DSU(n);
        boolean[] ans=new boolean[requests.length];
        int i=0;
        for(int[] it:requests){
            int pu=d.findpar(it[0]);
            int pv=d.findpar(it[1]);
            boolean flag=true;
            if(pu!=pv){
                for(int[] it2:restrictions){
                    int pu1=d.findpar(it2[0]);
                    int pv1=d.findpar(it2[1]);
                    
                    if((pu1==pu && pv1==pv) || (pu1==pv && pv1==pu)){
                        flag=false;
                        break;
                    }
                    
                }
                if(flag){
                    d.union(it[0],it[1]);
                }
                
            }
            ans[i++]=flag;
        }
        return ans;
        
    }
}