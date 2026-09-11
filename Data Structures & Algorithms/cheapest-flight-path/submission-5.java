class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,Map<Integer,Integer>> graph = new HashMap<>();
        for(int i=0 ;i<n ;i++){
            graph.put(i,new HashMap<>());
        }
        for(int [] flight : flights){
            int a=flight[0];
            int b=flight[1];
            int c = flight[2];
            graph.get(a).put(b,c);
        }
        Queue<int []> queue = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        queue.add(new int []{src,0,-1});
        Set<String> seen = new HashSet<>();
        while(!queue.isEmpty()){
            int [] curr = queue.remove();
            int currSrc = curr[0];
            int currCost = curr[1];
            int currK = curr[2];
            String key = currSrc+""+currCost;
            if(currK>k||seen.contains(key)){
                continue;
            }
            if(currSrc==dst){
                return currCost;
            }
            seen.add(key);
            Map<Integer,Integer> children = graph.get(currSrc);
            for(int child : children.keySet()){
                System.out.println("child "+child+ " currCost "+currCost+ " currK "+(currK+1));
               queue.add(new int []{child,currCost+children.get(child),currK+1});
            }
        }
        return -1;
    }
}
