class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,List<String>> graph = new HashMap<>();
        Map<String,String> emailToName = new HashMap<>();
        for(List<String> account : accounts){
            String name = account.get(0);
            String email = account.get(1);
            for(int i=1 ;i<account.size() ;i++){
                emailToName.put(account.get(i),name);
                if(!graph.containsKey(email)){
                    graph.put(email,new ArrayList<>());
                }
                graph.get(email).add(account.get(i));
                if(!graph.containsKey(account.get(i))){
                    graph.put(account.get(i),new ArrayList<>());
                }
                graph.get(account.get(i)).add(email);
            }
        }

        Set<String> seen = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        for(String email : graph.keySet()){
            if(seen.contains(email)){
                continue;
            }
            List<String> innerList = new LinkedList<>();
            dfs(graph,email,innerList,seen);
            Collections.sort(innerList);
            innerList.addFirst(emailToName.get(email));
            res.add(new ArrayList<>(innerList));
        }

        return res;
    }

    private static void dfs(Map<String,List<String>> graph,String email, List<String> innerList, Set<String> seen){
        if(seen.contains(email)){
            return;
        }
        seen.add(email);
        innerList.add(email);
        for(String nextEmail : graph.get(email)){
            dfs(graph,nextEmail,innerList,seen);
        }
    }
}