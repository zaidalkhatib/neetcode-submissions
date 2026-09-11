class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Set<Integer> seen = new HashSet<>();
        Map<Integer,Map<Integer,Integer>> graph = new HashMap<>();
        for(int i=1 ;i<=n ;i++){
            graph.put(i,new HashMap<>());
        }
        for(int [] time : times){
            int a=time[0];
            int b=time[1];
            int c=time[2];
            graph.get(a).put(b,c);
        }
        Queue<int[]> queue = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        queue.add(new int []{k,0});
        int cost=0;
        while(!queue.isEmpty()){
            int [] curr = queue.remove();
            int currSrc = curr[0];
            int currCost = curr[1];
            if(seen.contains(currSrc)){
                continue;
            }
            seen.add(currSrc);
            cost=Math.max(cost,currCost);
            Map<Integer,Integer> children = graph.get(currSrc);
            for(int child : children.keySet()){
                queue.add(new int []{child,currCost+children.get(child)});
            }
        }
        if(seen.size()==n) return cost;
        return -1;
    }
}
