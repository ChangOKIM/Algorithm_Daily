import java.io.*;
import java.util.*;

public class Main {
	//모음(a, e, i, o, u)한개 + 자음 두개 최소
	static int L, C;
	static char[] arr;
	static char[] temp;
	static StringTokenizer st;
	static StringBuilder sb;
	static char[] checkC;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		temp = new char[L];
		checkC = new char[] {'a', 'e', 'i', 'o', 'u'};
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		
		dfs(0, 0);
		System.out.println(sb);
	}
	
	static void dfs(int depth, int start) {
		if(depth == L) {
			if(isPassword(temp)) {
				for(int i=0; i<L; i++) {
					sb.append(temp[i]);
				}
				sb.append('\n');
			}
			return;
		}
		
		for(int i=start; i<C; i++) {
			temp[depth] = arr[i];
			dfs(depth+1, i+1);
		}
	}
	
	static boolean isPassword(char[] temp) {
		int zaCnt = 0;
		int moCnt = 0;
		
		for(int i=0; i<temp.length; i++) {
			boolean isMo = false;
			for(int j=0; j<5; j++) {
				if(temp[i] == checkC[j]) {
					isMo = true;
				}
			}
			
			if(isMo) {
				moCnt++;
			}else {
				zaCnt++;
			}
		}
		
		if(moCnt >= 1 && zaCnt >= 2) {
			return true;
		}else {
			return false;
		}
		
	}
		
}







