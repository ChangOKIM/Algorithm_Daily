import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int arr[];
    static int temp[];
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr =  new int[N];
        temp = new int[M];

        for(int i=1; i<N+1; i++){
            arr[i-1] =  i;
        }

        

        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs(int depth, int num){
        if(depth == M){
            for(int i=0; i<M; i++){
                sb.append(temp[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int i=num; i<N; i++){
            temp[depth] = arr[i];

            dfs(depth+1, i);

        }
    }
}
