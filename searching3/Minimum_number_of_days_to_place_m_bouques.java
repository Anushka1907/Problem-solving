public class Minimum_numbe_of_days_to_place_m_bouques {
    public int possible(int[] bloomDay, int mid,int m, int k){
        int count=0,no=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=mid){
                count++;
            }else{
                no+=(count/k);
                count=0;
            }
        }
        no+=(count/k);
        return no;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        long val= m*k;
        if(val>bloomDay.length) return -1;
        int low=Integer.MAX_VALUE;

        int high=Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            low=Math.min(low,bloomDay[i]);
            high=Math.max(high,bloomDay[i]);
        }
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(possible(bloomDay,mid,m,k)>=m){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}
