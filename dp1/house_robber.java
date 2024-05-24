class Solution {
    public int rob(int[] nums) {
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
}
