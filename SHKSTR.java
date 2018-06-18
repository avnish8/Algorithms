import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SHKSTR {
    public static class Trie {

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
            for (char ch : name.toCharArray()) {
                int index = ch - 'a';
                if (level.children[index] == null) {
                    level.children[index] = new TrieNode();
                    level = level.children[index];
                } else {
                    level = level.children[index];
                }
            }
            level.isEndOfWord = true;
        }

        public boolean findUtil(String name) {
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


        public String find(String name) {

            String s = "";
            TrieNode end;
            TrieNode level = root;
            for (char ch : name.toCharArray()) {
                int index = ch - 'a';
                if (level.children[index] == null) {
                    break;
                }
                String alphabet = Character.toString(ch);
                String temp = s + alphabet;
                s = temp;
                level = level.children[index];
            }
            end = level;
//            System.out.println(s);
            boolean foundEndOfWord = false;

            while (!foundEndOfWord) {
                if (end.isEndOfWord) {
                    foundEndOfWord = true;
                    break;
                }
                for (int i = 0; i < 26; i++) {
                    if (end.children[i] != null) {
                        String alphabet = Character.toString((char) ('a' + i));
                        String temp = s + alphabet;
                        s = temp;
                        end = end.children[i];
                        break;
                    }
                }
            }
            return s;
        }
     }

    static class Pairs implements Comparable<Pairs> {
        int integer;
        String string;
        int index;
        String answer;

        Pairs(int i, String s, int ind) {
            integer = i;
            string = s;
            index = ind;
        }

        public int compareTo(Pairs p) {
            return this.integer - p.integer;
        }

        public static Comparator<Pairs> indexCompare = new Comparator<Pairs>() {
            @Override
            public int compare(Pairs o1, Pairs o2) {
                return o1.index - o2.index;
            }
        };
    }

    public static Scanner in = new Scanner(System.in);

    static void addFromToTill(int f, int t, String[] strings, Trie trie) {
        for (int i = f; i <= t; i++) {
            trie.add(strings[i]);
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        String[] strings = new String[n];

        for (int i = 0; i < n; i++) strings[i] = in.next();

        int q = in.nextInt();
        Pairs[] pairs = new Pairs[q];

        for (int i = 0; i < q; i++) {
            int integer = in.nextInt() - 1;
            String pre = in.next();
            pairs[i] = new Pairs(integer, pre, i);
        }

        Arrays.sort(pairs);

        int addedTill = -1;

        Trie trie = new Trie();

        for (int i = 0; i < q; i++) {
            Pairs currentPair = pairs[i];
            if (currentPair.integer > addedTill) {
                addFromToTill(addedTill + 1, currentPair.integer, strings, trie);
                addedTill = currentPair.integer;
//                System.out.println("addedTill : " + addedTill);
//                System.out.println(trie.findUtil("abcde"));
            }
//            System.out.println(currentPair.integer + "  " + currentPair.string);
//            System.out.println(trie.findUtil("ab"));
            //find the prefix and print it
            pairs[i].answer = trie.find(currentPair.string);
        }

        Arrays.sort(pairs, Pairs.indexCompare);
        for (int i = 0; i < q; i++) {
            System.out.println(pairs[i].answer);
        }
    }
}