/*
    A program to print all combinations of sequences possible by typing on a candy-bar phone
 */

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class T9{
    
    static ArrayList<String> result = new ArrayList<>();
    
    static char[][] alphaKeys = {{' '}
            , {}
            , {'a', 'b', 'c'}
            , {'e', 'f', 'g'}
            , {'h', 'i', 'j'}
            , {'k', 'l', 'm'}
            , {'m', 'n', 'o'}
            , {'p', 'q', 'r', 's'}
            , {'t', 'u', 'v'}
            , {'w', 'x', 'y', 'z'}};
    
    static void dfs(String tillNow, String nextDigits) {
        if (nextDigits.equals("")) {
            result.add(tillNow);
            return;
        }
        
        int nextDigit = Integer.parseInt(nextDigits.substring(0, 1));

        for (int i = 0; i < alphaKeys[nextDigit].length; i++) {
            char nextChar = alphaKeys[nextDigit][i];
            dfs(tillNow + nextChar, nextDigits.substring(1));
        }
    }
    
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        PrintWriter writer = new PrintWriter("/Users/avnishsrivastava/Projects/Learning/src/outputFile.txt", "UTF-8");
        
        String digits = in.next();
        
        dfs("", digits);
        
        for (String s : result)
            writer.println(s);
        
        
        
    }
}

