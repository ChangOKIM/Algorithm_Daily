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
	static StringTokenizer st;
	static int N, M;
	static int[] arr;
	static ArrayList<Integer> temp;
	static int cnt;
	static int[][] bad;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N];
			for(int i=1; i<=N; i++) {
				arr[i-1] = i;
			}
			cnt = 0;
			temp = new ArrayList<Integer>();
			bad = new int[M][2];
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				bad[i][0] = Integer.parseInt(st.nextToken());
				bad[i][1] = Integer.parseInt(st.nextToken());
			}
			
			subset(0, temp);
			
			System.out.println("#" + tc + " " + cnt);
			
		}
	}
	
	static void subset(int idx, ArrayList<Integer> temp) {
		if(idx == N) {
			if(check(temp)) {
				cnt +=1;
			}
			return;
		}
		
		temp.add(arr[idx]);
		subset(idx+1, temp);
		temp.remove(temp.size() - 1);
		
		subset(idx+1, temp);
		
	}
	
	static boolean check(ArrayList<Integer> temp) {
		for(int i=0; i<M; i++) {
			int check_1 = bad[i][0];
			int check_2 = bad[i][1];
			
			if(temp.contains(check_1) && temp.contains(check_2)) {
				return false;
			}
		}
		return true;
	}
	
	
}