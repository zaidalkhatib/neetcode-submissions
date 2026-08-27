class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        // build the graph
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
        }

        for (int[] arr : trust) {
            int a = arr[0];
            int b = arr[1];
            graph.get(a).add(b);
        }
        System.out.print(graph);
        List<Integer> possibleJudge = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (graph.get(i).size() == 0) {
                possibleJudge.add(i);
            }
        }


        if (possibleJudge.size() == 0)
            return -1;
        for (int val : possibleJudge) {
            boolean judge = true;
            for (int key : graph.keySet()) {
                if (key!=val&&!graph.get(key).contains(val)) {
                    judge = false;
                    break;
                }
            }
            if (judge) {
                return val;
            }
        }
        return -1;
    }
}

// 1:3
// 4:3
// 2:3