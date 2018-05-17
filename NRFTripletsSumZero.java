import java.util.*;

class Triplet {
    int a;
    int b;
    int c;

    Triplet (int x, int y, int z) {
        int[] temp = {x, y, z};
        Arrays.sort(temp);
        this.a = temp[0];
        this.b = temp[1];
        this.c = temp[2];
    }
    @Override
    public boolean equals (Object obj) {
        if (obj instanceof Triplet) {
            Triplet t = (Triplet) obj;
            return (this.a == t.a && this.b == t.b && this.c == t.c);
        }
        else return false;
    }

    @Override
    public int hashCode () {
        return this.a + this.b * this.c;
    }

}

public class NRFTripletsSumZero {

    static HashSet <Triplet> FindTriplets (Integer[] input, Hashtable<Integer, Integer> hTable) {
        HashSet <Triplet> triplets = new HashSet<>();
        for (int i = 0, inputLength = input.length; i < inputLength; i++) {
            for (int j = i + 1; j < inputLength; j++) {
                int target = -1 * (input[i]+input[j]);
//                System.out.println("pair :" + i + " " + j + "  target  " + target);
                if (hTable.containsKey(target)) {
                    System.out.println("pair :" + input[i] + " " + input[j] + "  target found " + target);
                    if (target != input[i] && target != input[j]) {
                        Triplet t = new Triplet(input[i], input[j], target);
                        triplets.add(t);
                    }
                    else {
                        if (input[i] == 0 && input[j] == 0 && target == 0 && hTable.get(target) >= 3) {
                            Triplet t = new Triplet(input[i], input[j], target);
                            triplets.add(t);
                        }
                        else if ( hTable.get(target) > 1) {
                            Triplet t = new Triplet(input[i], input[j], target);
                            triplets.add(t);
                        }
                    }
                }
            }
        }
        return triplets;
    }

    public static void main (String[] args) {
        Integer[] input = {1, 2, 3, -3, 2, -1, 0, -4};

        Hashtable <Integer, Integer> hTable = new Hashtable <>();

        for (Integer i : input) {
            if (hTable.containsKey(i))  hTable.put(i, hTable.get(i) + 1);
            else hTable.put(i, 1);
        }

        System.out.println(hTable.entrySet());

        HashSet <Triplet> triplets = FindTriplets(input, hTable);

//        System.out.println(triplets);

        for (Triplet t: triplets) {
            System.out.println(t.a + " " + t.b + " " + t.c + "\n");
        }
    }
}