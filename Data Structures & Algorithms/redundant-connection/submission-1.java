class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if (!graph.containsKey(a)) {
                graph.put(a, new ArrayList<>());
            }
            if (!graph.containsKey(b)) {
                graph.put(b, new ArrayList<>());
            }
            graph.get(a).add(b);
            graph.get(b).add(a);
                    Set<Integer> seen = new HashSet<>();
            if(dfs(graph, a, -1, seen)){
                return edge;
            }
        }
        return new int []{};
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int src, int parent, Set<Integer> seen) {
        if (seen.contains(src)) {
            // list.add();
            return true;
        }
        seen.add(src);
        // System.out.print(graph + "  " + graph.get(src));
        for (int nei : graph.get(src)) {
            if (nei != parent) {
                if(dfs(graph, nei, src, seen)){
                    return true;
                }
            }
        }
        return false;
    }
}
