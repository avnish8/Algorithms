/*
    A simple trie Data Structure to add an string and later check if it exists
 */

public class Trie {

    public static class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndOfWord = false;

        TrieNode() {
            for (TrieNode t : children)
                t = null;
        }
    }

    TrieNode root;

    Trie() {
        this.root = new TrieNode();
    }

    public void add(String name) {
        TrieNode level = root;
        for (char ch : name.toCharArray()){
            int index = ch - 'a';
            if (level.children[index] == null){
                level.children[index] = new TrieNode();
                level = level.children[index];
            }
            else {
                level = level.children[index];
            }
        }
        level.isEndOfWord = true;
    }

    public boolean find(String name) {
        TrieNode level = root;
        for (char ch : name.toCharArray()) {
            int index = ch - 'a';
            if (level.children[index] == null)
                return false;
            level = level.children[index];
        }
        if (level.isEndOfWord)
            return true;
        return false;
    }
}
