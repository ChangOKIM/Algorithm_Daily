import java.util.*;
import java.io.*;

public class Main {
	
	static class Node implements Comparable<Node>{
		int to, cost;
		
		Node(int to, int cost){
			this.to = to;
			this.cost = cost;
		}
		
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	static StringTokenizer st;
	static int V, E, K;
	static ArrayList<Node>[] graph;
	static final int INF = Integer.MAX_VALUE;
	static int[] dist;
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[V + 1];
		dist = new int[V+1];
		
		for(int i=1; i<= V; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = INF;
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v, w));
		}
		
		dijkstra(K);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=V; i++) {
			if(dist[i] == INF) sb.append("INF").append("\n");
			else sb.append(dist[i]).append("\n");
		}
		
		System.out.println(sb);
		
		
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(dist[now.to] < now.cost) continue;
			
			for(Node next : graph[now.to]) {
				int nextCost = dist[now.to] + next.cost;
				
				if(dist[next.to] > nextCost) {
					dist[next.to] = nextCost;
					pq.add(new Node(next.to, nextCost));
				}
			}
		}
	}
}
