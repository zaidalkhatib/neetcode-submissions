class Solution {
    public int minCostConnectPoints(int[][] points) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            int xi = points[i][0];
            int yi = points[i][1];
            for (int j = i+1; j < points.length; j++) {
                int xj = points[j][0];
                int yj = points[j][1];
                int cost = Math.abs(xi - xj) + Math.abs(yi - yj);
                if (!graph.containsKey(i)) {
                    graph.put(i, new HashMap<>());
                }
                if (!graph.containsKey(j)) {
                    graph.put(j, new HashMap<>());
                }
                graph.get(i).put(j, cost);
                graph.get(j).put(i, cost);
            }
        }
        // System.out.print(graph);
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        queue.add(new int[] {0, 0});
        int cost = 0;
        Set<Integer> seen = new HashSet<>();
        while (!queue.isEmpty()) {
            int[] currArr = queue.remove();
            int currSrc = currArr[0];
            int currCost = currArr[1];
            if (seen.contains(currSrc)) {
                continue;
            }
            seen.add(currSrc);
            cost += currCost;
            Map<Integer, Integer> children = graph.get(currSrc);
            if (children != null) {
                for (int child : children.keySet()) {
                    queue.add(new int[] {child, children.get(child)});
                }
            }
        }

        return cost;
    }
}
