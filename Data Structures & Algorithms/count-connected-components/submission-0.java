class Solution {
    public int countComponents(int n, int[][] edges) {
        Set<Integer> seen = new HashSet<>();
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i=0 ;i<n ;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int [] edge : edges){
            int parent = edge[0];
            int child = edge[1];
            graph.get(parent).add(child);
            graph.get(child).add(parent);
        }
        int count=0;
        for(int src : graph.keySet()){
            if(seen.contains(src)){
                continue;
            }
            dfs(graph,src,seen);
            count++;
        }
        return count;
    }

    private void dfs(Map<Integer,List<Integer>> graph,int src, Set<Integer> seen){
        if(seen.contains(src)){
            return;
        }
        seen.add(src);
        for(int nei : graph.get(src)){
            dfs(graph,nei,seen);
        }
    }
}
