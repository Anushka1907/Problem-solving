class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp=new long[questions.length+1];
        for(int i=questions.length-1;i>=0;i--){
            int count=questions[i][0];
            int jump=questions[i][1];
            int next=Math.min(questions.length,i+jump+1);
            dp[i]=Math.max(dp[i+1],count+dp[next]);
        }
        return dp[0];
    }
}
