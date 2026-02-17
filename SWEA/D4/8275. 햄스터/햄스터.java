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
	static int[] temp;
	static int[] search;
	static int[][] records;
	static int max_ham, records_check; //햄스터 최대수 체크용, 기록 맞는지
	static ArrayList<int[]> max_val; //햄스터 최대일 때 리스트 저장용
	static int N, X, M;
	static int[] result;
	static boolean is_found;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());  //우리 수
			X =Integer.parseInt(st.nextToken());  //우리당 최대 햄스터
			M = Integer.parseInt(st.nextToken()); //기록 수
			
			records = new int[M][3];
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				records[i][0] = Integer.parseInt(st.nextToken()); //시작 우리
				records[i][1] = Integer.parseInt(st.nextToken());  //끝 우리
				records[i][2] = Integer.parseInt(st.nextToken()); //햄스터 정확히 개수
				
				
			}
			temp = new int[N];
			search = new int[X+1];
			for(int i=0; i<=X; i++) search[i] = i;
			max_ham = -1;
			max_val = new ArrayList<int[]>();
			result = new int[N];
			is_found = false;
			
			dfs(0);
			
			
			if(!is_found) {
				System.out.println("#" + tc + " " + -1);
			}else {
				StringBuilder sb = new StringBuilder();
				for(int i=0; i<result.length; i++) {
					sb.append(result[i]).append(" ");
				}
				System.out.println("#" + tc + " " + sb);
			}

		}
	}
	
	static void dfs(int depth) {
		if(depth == N) {
			
			if(is_avail(temp)) {
				
				int check_max = 0;
				for(int i=0; i<N; i++) {
					check_max += temp[i];
				}
				if(check_max>max_ham) {
					for(int i=0; i<N; i++) {
						result[i] = temp[i];
					}
					is_found = true;
					max_ham = check_max;
				}
			}
			return;
		}
		
		for(int i=0; i<=X; i++) {
			temp[depth] = search[i];
			dfs(depth + 1);
		}
	}
	
	static boolean is_avail(int[] temp) {
		records_check = 0;
		for(int i=0; i<M; i++) {
			int sum_ham = 0;
			int start = records[i][0]-1;
			int end = records[i][1];
			
			for(int j=start; j<end; j++) {
				sum_ham += temp[j];
			}
			
			if(sum_ham == records[i][2]) records_check +=1;	
		}
		
		if(records_check == M) {
			return true;
		}else {
			return false;
		}
    }
}