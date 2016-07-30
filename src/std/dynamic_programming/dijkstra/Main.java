package std.dynamic_programming.dijkstra;

import java.util.ArrayList;
import java.util.List;

class Graph {
    
    private final int[][] b;
    
    public Graph(int n) {
        b = new int[n][];
        for (int i = 0; i < n; i++) {
            b[i] = new int[n];
            for (int j = 0; j < n; j++) {
                b[i][j] = -1;
            }
        }
    }

    public void add(int u, int v, int w) {
        b[u][v] = w;
    }

    public List<Integer> edges(int u) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size(); i++) {
            if (b[u][i] != -1) {
                result.add(i);
            }
        }
        return result;
    }

    public int get(int u, int v) {
        return b[u][v];
    }

    public int size() {
        return b.length;
    }
}

public class Main {
    private static int getMinIndex(int[] D, boolean[] V) {
        // Get the index which has got the minimum distance
        int index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < D.length; i++) {
            if (V[i] == false && min > D[i]) {
                min = D[i];
                index = i;
            }
        }
        return index;
    }

    private static void dijkstra(Graph G, int S) {
        int n = G.size();
        int[] D = new int[n];           // distance
        int[] P = new int[n];           // previous
        boolean[] V = new boolean[n];   // visited

        for (int i = 0; i < n; i++) {
            D[i] = Integer.MAX_VALUE;
            P[i] = -1;
            V[i] = false;
        }

        D[S] = 0;

        while (true) {
            int u = getMinIndex(D, V);
            if (u == -1) {
                break;
            }
            V[u] = true;

            for (Integer v : G.edges(u)) {
                if (D[v] > D[u] + G.get(u, v)) {
                    D[v] = D[u] + G.get(u, v);
                    P[v] = u;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(String.format("%d %d %d", S, i, D[i]));
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);

        g.add(0, 2, 2);
        g.add(0, 1, 1);
        g.add(0, 3, 1);
        g.add(2, 5, 4);
        g.add(1, 4, 1);
        g.add(4, 5, 1);
        g.add(3, 1, 1);

        dijkstra(g, 0);
    }
}
