class Solution {
    public int rob2(int[] nums) {
        int prev=nums[0];
        int prev2=0;
        int n=nums.length;
        for(int i=1;i<n;i++){
            int take=nums[i];
            if(i>0) take+=prev2;
            int nottake=0+prev;
            int cur=Math.max(take,nottake);
            prev2=prev;
            prev=cur;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int[] temp1=new int[n];
        int[] temp2=new int[n];
        if(n==1){
            return nums[0];
        }
        for(int i=0;i<n;i++){
            if(i!=0){
                temp1[i]=nums[i];
            }
            if(i!=n-1){
                temp2[i]=nums[i];
            }
        }
        return Math.max(rob2(temp1),rob2(temp2));
    }
}
