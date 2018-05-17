import java.util.LinkedList;
import java.util.Scanner;

public class CtciBFS {

    public static class Graph {

        LinkedList<Integer> adjList[];

        Graph(int n) {
            adjList = new LinkedList[n];
            for (int i = 0; i < n; i++) adjList[i] = new LinkedList<>();
        }

        public void add(int u, int v) {
            adjList[u - 1].add(v - 1);
            adjList[v - 1].add(u - 1);
        }

        public void bfs(int[] result, int vertex) {
            result[vertex] = 0;

            int distanceFromVertex = 6;
            for (int i : adjList[vertex])
                result[i] = distanceFromVertex;

            LinkedList<Integer>  current = adjList[vertex];
            LinkedList<Integer> next = new LinkedList();

            distanceFromVertex += 6;
            while (!current.isEmpty()){
                for (int i : current) {
                    for (int j : adjList[i]){
                        if (j != vertex && result[j] == 0){
                            next.add(j);
                            result[j] = distanceFromVertex;
                        }
                    }
                }
                current = next;
                next = new LinkedList();
                distanceFromVertex += 6;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int q = in.nextInt();
        while (q-- > 0) {
            int n, m; n = in.nextInt(); m = in.nextInt();

            Graph g = new Graph(n);

            int u, v;
            while (m-- > 0) { u = in.nextInt(); v = in.nextInt(); g.add(u, v); }

            int startingVertex = in.nextInt(); startingVertex--;

            int result[] = new int[n];

            g.bfs(result, startingVertex);

            for (int i = 0; i < n; i++){
                if (i != startingVertex)
                    if (result[i] == 0) System.out.print(-1 + " ");
                    else System.out.print(result[i] + " ");
            }
            System.out.println("");
        }
    }
}