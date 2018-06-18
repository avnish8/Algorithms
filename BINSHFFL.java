/*
    CodeChef problem
    an operation consists of shuffling all the bits of 'a' and adding 1 to it
    find minimum number of operations to convert 'a' to 'b'
 */

import java.util.Scanner;

public class BINSHFFL {

    static int shuf(long adup, long bm1) {

        if (adup == bm1 + 1) return 0;
        if (bm1 == 0 && adup == 0) return 1;
        else if (bm1 == 0) return -1;

        int bm11 = 0;
        int adup1 = 0;

        if (bm1 == -1) {
            return -1;
        }
        else {
            while (bm1 > 0) {
                if (bm1 % 2 == 1) bm11++;
                bm1 = bm1 >> 1;
            }
        }

        while (adup > 0) {
            if (adup % 2 == 1) adup1++;
            adup = adup >> 1;
        }

        if (adup1 == bm11) return 1;
        else if (adup1 > bm11) return 2;
        else return bm11 - adup1 + 1;
    }

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-- > 0) {

            long a = in.nextLong();
            long b = in.nextLong();
//
//            String a = in.next();
//            String b = in.next();

//            System.out.println(Binary.toDecimal(a) + " " + Binary.toDecimal(b));
            System.out.println(shuf(a, b - 1));
        }
    }
}
