class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i=0 ;i<n ;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int []edge : edges){
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        Set<Integer> seen = new HashSet();
        if(!dfs(graph,0,-1, seen)){
            return false;
        }
        return seen.size()==n;
    }

    private boolean dfs(Map<Integer,List<Integer>> graph, int src,int parent,Set<Integer> seen){
        if(seen.contains(src)){
            return false;
        }
        seen.add(src);
        for(int nei : graph.get(src)){
            if(nei!=parent){
                if(!dfs(graph,nei,src,seen)){
                    return false;
                }
            }
        }
        return true;
    }
}
