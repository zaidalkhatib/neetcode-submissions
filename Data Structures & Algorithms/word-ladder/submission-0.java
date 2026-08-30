class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        Set<String> seen = new HashSet<>();
        while (!queue.isEmpty()) {
            Pair currPair = queue.remove();
            String currWord = currPair.word;
            int currDis = currPair.dis;
            if (seen.contains(currWord)) {
                continue;
            }
            seen.add(currWord);
            if (currWord.equals(endWord)) {
                return currDis;
            }

            for (String word : wordList) {
                if (!word.equals(currWord)) {
                    int diffCount = 0;
                    for (int i = 0; i < currWord.length(); i++) {
                        if (currWord.charAt(i) != word.charAt(i)) {
                            diffCount++;
                        }
                    }
                    if (diffCount == 1) {
                        queue.add(new Pair(word, currDis + 1));
                    }
                }
            }
        }
        return 0;
    }
}
public class Pair {
    String word;
    int dis;
    public Pair(String word, int dis) {
        this.word = word;
        this.dis = dis;
    }
}
