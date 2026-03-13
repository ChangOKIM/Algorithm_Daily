import java.util.*;
import java.io.*;

public class Main {
    static int V, E, K;
    static ArrayList<Node>[] graph;
    static int[] distance;
    static StringTokenizer st;
    static final int INF = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        distance = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = INF;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (distance[i] == INF) sb.append("INF").append("\n");
            else sb.append(distance[i]).append("\n");
        }

        System.out.print(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            int nowEnd = now.end;
            int nowWeight = now.weight;

            if (distance[nowEnd] < nowWeight) continue;

            for (int i = 0; i < graph[nowEnd].size(); i++) {
                Node next = graph[nowEnd].get(i);

                if (distance[next.end] > nowWeight + next.weight) {
                    distance[next.end] = nowWeight + next.weight;
                    pq.add(new Node(next.end, distance[next.end]));
                }
            }
        }
    }
}