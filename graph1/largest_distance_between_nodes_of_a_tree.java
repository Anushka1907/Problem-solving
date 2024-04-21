class Solution {
    int height(int node, List<List<Integer>> adj, int[] ans) {
        int maxi = 0;

        for (int it : adj.get(node)) {
            int nextHeight = height(it, adj, ans);
            ans[0] = Math.max(ans[0], maxi + nextHeight);
            maxi = Math.max(maxi, nextHeight);
        }

        return 1 + maxi;
    }

    public int solve(List<Integer> A) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = A.size();
        int root = -1;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            if (A.get(i) == -1) {
                root = i;
                continue;
            }
            adj.get(A.get(i)).add(i);
        }

        int[] ans = { 0 };
        height(root, adj, ans);

        return ans[0];
    }
}
