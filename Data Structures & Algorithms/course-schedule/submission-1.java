class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        Map<Integer,Integer> inDegree = new HashMap<>();
        for(int i=0 ;i<numCourses ;i++){
            graph.put(i,new ArrayList<>());
            inDegree.put(i,0);
        }

        for(int [] list : prerequisites){
            int child = list[0];
            int parent = list[1];
            graph.get(parent).add(child);
        }
        for(int parent : graph.keySet()){
            for(int child : graph.get(parent)){
                inDegree.put(child,inDegree.get(child)+1);
            }
        }
        Queue<Integer> queue = new LinkedList();
        for(int child : inDegree.keySet()){
            if(inDegree.get(child)==0){
                queue.add(child);
            }
        }
        // List<Integer> list = new ArrayList<>();
        int counter=0;
        while(!queue.isEmpty()){
            int curr = queue.remove();
            counter++;
            for(int child : graph.get(curr)){
                inDegree.put(child,inDegree.get(child) - 1);
                if(inDegree.get(child)== 0){
                    queue.add(child);
                }
            }
        }

        return counter==numCourses;
    }
}
