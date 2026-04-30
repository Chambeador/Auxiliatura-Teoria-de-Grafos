package Algoritmos;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Kruskal {

    static class Edge implements Comparable<Edge> {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge other) {
            return this.w-other.w;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            pq.add(new Edge(u, v, w));
        }

        DSU1 dsu = new DSU1(n+1);
        int costo = 0;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            if (dsu.join(e.u, e.v) == 1) {
                costo += e.w;
            }
        }
        System.out.println(costo);
    }
}