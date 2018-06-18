
public class Binary {

    static long toDecimal(String s) {
        char[] bits = s.toCharArray();
        long num = 0;
        long mul = 1;
        for (int i = bits.length - 1; i >= 0; i--) {
            if (bits[i] == '1') num += mul;
            mul *= 2;
        }
        return num;
    }

    static int[] toBinaryArray(long num) {
        int bits = 0;
        long numCopy = num;
        while (numCopy != 0) {
            numCopy >>= 1;
            bits++;
        }
        bits = bits == 0 ? 1: bits;
        int[] bitArray = new int[bits];

        for (int i = bits - 1; i >= 0; i--, num >>= 1) {
            if (num % 2 == 1) bitArray[i] = 1;
            else bitArray[i] = 0;
        }

        return bitArray;
    }

    static String toBinaryString(long num) {
        int[] b = toBinaryArray(num);
        String[] c = new String[b.length];

        for (int i = 0, j = b.length; i < j; i++) {
            c[i] = String.valueOf(b[i]);
        }
        return String.join("", c);
    }

}
