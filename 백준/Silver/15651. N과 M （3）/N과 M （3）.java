import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int[] temp;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		arr = new int[N];

		for(int i=1; i<=N; i++){
			arr[i-1] = i;
		}
		M = Integer.parseInt(st.nextToken());
		temp = new int[M];

		combination(0);

		System.out.println(sb);
		
	}

	static void combination(int depth){
		if(depth == M){
			for(int i=0; i<M; i++){
				sb.append(temp[i]).append(" ");
			}
			sb.append('\n');
			return;
		}

		for(int i=0; i<N; i++){
			temp[depth] = arr[i];
			combination(depth+1);

		}
	}
}