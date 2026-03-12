import java.util.*;
import java.io.*;

public class Main {
    static int V, E, K;
    static ArrayList<Node>[] graph;
    static int[] distance;
    static boolean[] visited;
    static StringTokenizer st;
    static final int INF = Integer.MAX_VALUE;

    static class Node {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
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
        visited = new boolean[V + 1];

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
        distance[start] = 0;

        for (int i = 1; i <= V; i++) {
            int min = INF;
            int current = -1;

            for (int j = 1; j <= V; j++) {
                if (!visited[j] && distance[j] < min) {
                    min = distance[j];
                    current = j;
                }
            }

            if (current == -1) break;

            visited[current] = true;

            for (int j = 0; j < graph[current].size(); j++) {
                Node next = graph[current].get(j);

                if (!visited[next.end] && distance[current] != INF
                        && distance[next.end] > distance[current] + next.weight) {
                    distance[next.end] = distance[current] + next.weight;
                }
            }
        }
    }
}