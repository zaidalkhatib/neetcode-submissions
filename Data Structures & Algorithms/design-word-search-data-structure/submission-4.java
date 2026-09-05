class WordDictionary {
    Node root = new Node();
    public WordDictionary() {}

    public void addWord(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.letters[ch - 'a'] == null) {
                curr.letters[ch - 'a'] = new Node();
            }
            curr = curr.letters[ch - 'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        Node curr = root;
        return helper(curr, word,0);
    }

    private boolean helper(Node curr, String word,int index) {
        if (word.length() == 0) {
            return true;
        }
        if (curr == null)
            return false;

        for (int i = index; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for(char ch='a' ;ch<='z' ;ch++){
                    char [] chars = word.toCharArray();
                    chars[i]=ch;
                    if(helper(curr,new String(chars),i)){
                        return true;
                    }
                }
                return false;
            } else {
                if (curr.letters[word.charAt(i) - 'a'] == null) {
                    return false;
                }
            }
            curr = curr.letters[word.charAt(i) - 'a'];
        }
        return curr.isWord;
    }

    static class Node {
        Node[] letters = new Node[26];
        boolean isWord = false;
        char ch;
    }
}
