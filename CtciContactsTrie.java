import java.io.*;
import java.util.*;

public class CtciContactsTrie {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
        long subTrieValue = -1;

        TrieNode () {
            for (TrieNode t : children)
                t = null;
        }
    }

    private static void add (String name, TrieNode root){
        TrieNode level = root;
        for (char ch : name.toCharArray()){
            int index = ch - 'a';
            if (level.children[index] == null){
                level.children[index] = new TrieNode();
                level = level.children[index];
            }
            else {
                level = level.children[index];
                level.subTrieValue = -1;
            }
        }
        level.isEndOfWord = true;
    }

    private static long count (TrieNode node){
        if (node.subTrieValue != -1)
            return node.subTrieValue;
        long sum = 0;
        if (node.isEndOfWord) sum++;
        for (TrieNode pointer: node.children){
            if (pointer != null)
                sum += count(pointer);
        }
        node.subTrieValue = sum;
        return sum;
    }

    private static void find (String partialName, TrieNode root){
        // TrieNode from end of partial Name
        TrieNode tail = findUtil(partialName, root);
        if (tail == null) System.out.println(0);
        else{
            System.out.println(count(tail));
        }
    }

    private static TrieNode findUtil (String name, TrieNode root){
        TrieNode level = root;
        for (char ch : name.toCharArray()){
            int index = ch - 'a';
            if (level.children[index] == null) return null;
            else{
                level = level.children[index];
            }
        }
        return level;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TrieNode root = new TrieNode();
        int flag = 0;
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if (op.equals("add")) add(contact, root);
            else find(contact, root);
        }
    }
}