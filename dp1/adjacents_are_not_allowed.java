class MaxSum {

    public static int maxSum(int n, int[][] mat) {
        int f = 0;
        int s = Math.max(mat[0][0], mat[1][0]);
        if (n == 1) {
            return s;
        }
        for (int i = 2; i <= n; i++) {
            int curr = Math.max(Math.max(mat[0][i - 1], mat[1][i - 1]) + f, s);
            f = s;
            s = curr;
        }
        return s;
    }
}
