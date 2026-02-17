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
	static int[] iy;
	static int[] temp;
	static boolean[] visited;
	static int[] gy;
	static boolean[] check1;
	static ArrayList<Integer> check2;
	static StringTokenizer st;
	static int win_iy, win_gy;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			iy = new int[9];
			temp = new int[9];
			visited = new boolean[9];
			check1 = new boolean[19];
			gy = new int[9];
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<9; i++) {
				gy[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0; i<9; i++) {
				check1[gy[i]] = true;
			}
			
			check2 = new ArrayList<Integer>();
			
			for(int i=1; i<=18; i++) {
				if(!check1[i]) {
					check2.add(i);
				}
			}
			
			for(int i=0; i<9; i++) {
				iy[i] = check2.get(i);
			}
						
			win_iy = 0;
			win_gy = 0;
			
			dfs(0);
			
			System.out.println("#" + tc + " " + win_gy + " " + win_iy);
		}
	}
	
	static void dfs(int depth) {
		if(depth == 9) {
			int cnt_i = 0;
			int cnt_g = 0;
			for(int i= 0; i<9; i++) {
				if(temp[i] > gy[i]) {
					cnt_i += temp[i] + gy[i];
				}else {
					cnt_g += temp[i] + gy[i];
				}
			}
			if(cnt_i > cnt_g) {
				win_iy +=1;
			}else {
				win_gy +=1;
			}
		}
		
		
		for(int i=0; i<9; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			temp[depth] = iy[i];
			dfs(depth+1);
			visited[i] = false;
		}	
    }
}