import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class TempFileIO {

    public static void main(String[] args) throws Exception {
        File file = new File("/Users/avnishsrivastava/Projects/Learning/src/inputFile.txt");
        Scanner in = new Scanner(file);
        PrintWriter writer = new PrintWriter("/Users/avnishsrivastava/Projects/Learning/src/outputFile.txt", "UTF-8");
        long startTime = System.nanoTime();


        long endTime = System.nanoTime();
        System.out.printf("%.6f", ((endTime - startTime) * 1.0) / 1000000000 );
        in.close();
    }

}
