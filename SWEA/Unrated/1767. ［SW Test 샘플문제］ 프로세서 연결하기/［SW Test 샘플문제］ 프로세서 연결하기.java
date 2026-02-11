/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int N;
	static int[][] graph;
	static int cnt_max, sum_min;
	static int cnt, sum;  // 연결된 코어수, 전선 길이 합
	static StringTokenizer st;
	static ArrayList<int[]> cores; // {x, y}
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			graph = new int[N][N];
			cores = new ArrayList<>();
			cnt_max = 0;
			sum_min = Integer.MAX_VALUE;

			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=1; i<N-1; i++) {
				for(int j=1; j<N-1; j++) {
					if(graph[i][j] == 1) cores.add(new int[]{i, j});
				}
			}
			
			dfs(0, 0, 0);
			
			System.out.println("#" + tc + " "+ sum_min);
		}
		
	}
		
		static void dfs(int idx, int sum, int cnt) {
			if(idx == cores.size()) {
				if(cnt>cnt_max) {
					sum_min = sum;
					cnt_max = cnt;
				}else if(cnt== cnt_max) {
					if(sum < sum_min) {
						sum_min = sum;
					}
				}
				return;
			}
			int x = cores.get(idx)[0];
			int y = cores.get(idx)[1];
			
			for(int d=0; d<4; d++) {
				if(!canLay(x, y, d)) continue; //전선 못깔면 안돼
				
				int len = lay(x, y, d, 2); //전선 깔기
				dfs(idx+1, sum+len, cnt +1);
				lay(x, y, d, 0);  //전선 복구
			}
			
			dfs(idx+1, sum, cnt);
		}
		
		static boolean canLay(int x, int y, int d) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			while(0<= nx && nx<N && 0<= ny && ny<N) {
				if(graph[nx][ny] != 0) return false;
				nx +=dx[d];
				ny += dy[d];
			}
			return true;
		}
		
		static int lay(int x, int y, int d, int val) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			int len = 0;
			
			while(0<= nx && nx<N && 0<= ny && ny<N) {
				graph[nx][ny] = val;
				len +=1;
				nx +=dx[d];
				ny += dy[d];
			}
			return len;
        }
}