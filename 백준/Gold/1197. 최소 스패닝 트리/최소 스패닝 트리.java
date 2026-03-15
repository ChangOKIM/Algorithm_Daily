import java.util.*;
import java.io.*;

public class Main {
	static StringTokenizer st;
	static int V, E;
	static int[] parent;
	
	static class Edge implements Comparable<Edge>{
		int from, to, cost;
		
		Edge(int from, int to, int cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
	static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa == pb) {
			return false;
		}
		parent[pb] = pa;
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		Edge[] edges = new Edge[E];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(a, b, c);
		}
		
		Arrays.sort(edges);
		
		parent = new int[V+1];
		
		for(int i=1; i<=V; i++) {
			parent[i] = i;
		}
		
		int result = 0;
		
		for(Edge e : edges) {
			if(union(e.from, e.to)) {
				result += e.cost;
			}
		}
		
		System.out.println(result);
		
		
	}
}
