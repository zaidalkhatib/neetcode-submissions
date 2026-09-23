class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer,Integer> graph = new HashMap<>();
        
        for(int [] edge : edges){
            int a = edge[0];
            int b = edge[1];
            if(!graph.containsKey(a)){
                graph.put(a,a);
            }
            if(!graph.containsKey(b)){
                graph.put(b,b);
            }
            if(union(a,b,graph)){
                return edge;
            }
        }
        return new int []{};
    }

    private static boolean union(int a, int b,Map<Integer,Integer> graph ){
        int rootA=find(a,graph);
        int rootB=find(b,graph);
        if(rootA==rootB){
            return true;
        }
        graph.put(rootB,rootA);
        return false;
    }

    private static int find(int root,Map<Integer,Integer> graph){
        if(graph.get(root)==root){
            return root;
        }

        return find(graph.get(root),graph);
    }
}
