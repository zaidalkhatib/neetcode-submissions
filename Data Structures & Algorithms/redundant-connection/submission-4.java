class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int [] edge : edges){
            int a = edge[0];
            int b= edge[1];
            if(!graph.containsKey(a)){
                graph.put(a,new ArrayList<>());
            }
            if(!graph.containsKey(b)){
                graph.put(b,new ArrayList<>());
            }
            graph.get(a).add(b);
            graph.get(b).add(a);
            Set<Integer> visited = new HashSet<>();
            if(dfs(graph,a,-1,visited)){
                return edge;
            }
        }
        return new int []{};
    }

    private static boolean dfs(Map<Integer,List<Integer>> graph, int src, int parent, Set<Integer> visited){
        if(visited.contains(src)){
            return true;
        }
        visited.add(src);
        for(int nei : graph.get(src)){
            if(nei!=parent){
                if(dfs(graph,nei,src,visited)){
                    return true;
                }
            }
        }
        return false;
    }
}
