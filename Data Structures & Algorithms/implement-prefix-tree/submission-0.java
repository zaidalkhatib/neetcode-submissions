class PrefixTree {
    Node root = new Node();
    public PrefixTree() {
         
    }

    public void insert(String word) {
        Node curr = root;
        for(char ch :word.toCharArray()){
            if(curr.letters[ch-'a']==null){
                curr.letters[ch-'a']=new Node();
            }
            curr=curr.letters[ch-'a'];
        }
        curr.isWord=true;
    }

    public boolean search(String word) {
        Node curr = root;
        for(char ch :word.toCharArray()){
            if(curr.letters[ch-'a']==null){
                return false;
            }
            curr=curr.letters[ch-'a'];
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char ch :prefix.toCharArray()){
            if(curr.letters[ch-'a']==null){
                return false;
            }
            curr=curr.letters[ch-'a'];
        }
        return true;
    }


    static class Node {
        Node [] letters = new Node [26];
        boolean isWord=false;
    }
}
