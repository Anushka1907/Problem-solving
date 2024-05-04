class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // create graph
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int x2 = points[i][1];
                int y1 = points[j][0];
                int y2 = points[j][1];
                int d = Math.abs(x1 - y1) + Math.abs(x2 - y2);
                graph[i].add(new int[] { j, d });
                graph[j].add(new int[] { i, d });
            }
        }

        int res = 0;
        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.offer(new int[] { 0, 0 });

        while (visited.size() < n && !queue.isEmpty()) {
            int[] pair = queue.poll();
            int currNode = pair[0];
            int currWt = pair[1];
            if (visited.contains(currNode))
                continue;
            visited.add(currNode);
            res += currWt;
            for (int[] e : graph[currNode]) {
                if (visited.contains(e[0]))
                    continue;
                queue.offer(e);
            }
        }

        return res;
    }
}
