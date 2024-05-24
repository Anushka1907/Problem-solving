class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length(),m=text2.length();
        int[] dp=new int[m+1];
        
        for(int i=1;i<=n;i++){
            int prev=0;
            for(int j=1;j<=m;j++){
                int cur=dp[j];
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[j]=1 + prev;
                }
                else{
                    dp[j]=Math.max(dp[j-1],cur);
                }
                prev=cur;
            }
        }
        return dp[m];
    }
}
