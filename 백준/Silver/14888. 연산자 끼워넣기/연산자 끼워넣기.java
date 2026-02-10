import java.util.*;
import java.io.*;


public class Main {
    static int N, cur, max,min; //고정 변수들
    static int[] arr; //숫자 리스트 
    static int[] sign; //부호 개수들 덧셈, 뺄셈, 곱셈, 나눗셈
    static int[] check; // 부호 개수가 채워지는지 백트랙킹용
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        cur = 0;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        sign = new int[4];
        check = new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            sign[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0]);  //느낌적으로 뭔가 탐색해야될거 depth랑 계산 누적해서 더할 cur 매개로 보내야겠다는 느낌
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int depth, int cur){
        if(depth == N){
            if(cur>max) max = cur;
            if(cur<min) min = cur;
            return;
        }

        if(sign[0]>check[0]){
            check[0] +=1;
            dfs(depth + 1, cur + arr[depth]);
            check[0] -=1;
        }
        if(sign[1]>check[1]){
            check[1] +=1;
            dfs(depth + 1, cur - arr[depth]);
            check[1] -=1;
        }
        if(sign[2]>check[2]){
            check[2] +=1;
            dfs(depth + 1, cur * arr[depth]);
            check[2] -=1;
        }
        if(sign[3]>check[3]){
            check[3] +=1;
            dfs(depth + 1, cur / arr[depth]);
            check[3] -=1;
        }
    }

}
