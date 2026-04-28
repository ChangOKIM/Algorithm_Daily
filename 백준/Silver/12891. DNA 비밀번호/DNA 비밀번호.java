import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		String acgt = br.readLine();
		
		int[] check = new int[4];
		int[] check_t = new int[4];
		
		String min_val = br.readLine();
		StringTokenizer st2 = new StringTokenizer(min_val);
		for(int i=0; i<4; i++) {
			check[i] = Integer.parseInt(st2.nextToken());
		}
		
		int answer = 0;
		
		String init = acgt.substring(0, P);
		for(int i=0; i<P; i++) {
			char init_c = init.charAt(i);
			if (init_c == 'A') check_t[0]++;
			else if (init_c == 'C') check_t[1]++;
			else if (init_c == 'G') check_t[2]++;
			else if (init_c == 'T') check_t[3]++;
		}
		
		if (check_t[0] >= check[0] && check_t[1] >= check[1] && check_t[2] >= check[2] && check_t[3] >= check[3]) {
			answer++;
		}
		
		for (int i = P; i < S; i++) {
			char left = acgt.charAt(i - P);
			if (left == 'A') check_t[0]--;
			else if (left == 'C') check_t[1]--;
			else if (left == 'G') check_t[2]--;
			else if (left == 'T') check_t[3]--;

			char right = acgt.charAt(i);
			if (right == 'A') check_t[0]++;
			else if (right == 'C') check_t[1]++;
			else if (right == 'G') check_t[2]++;
			else if (right == 'T') check_t[3]++;

			if (check_t[0] >= check[0] && check_t[1] >= check[1] && check_t[2] >= check[2] && check_t[3] >= check[3]) {
				answer++;
			}
		}
		
		System.out.println(answer);
		
		
	}
}