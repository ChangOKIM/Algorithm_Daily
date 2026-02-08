import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int count = 0;
    static int N, S;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        String str = br.readLine();

        st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        S = Integer.parseInt(st.nextToken());

        String str2= br.readLine();

        st = new StringTokenizer(str2);

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());

        }

        dfs(0, 0);

        if( S == 0) count--;

        System.out.println(count);
    }

    static void dfs(int idx, int sum){
        if(idx == N){
            if(sum == S) count++;
            return;
        }

        dfs(idx +1, sum + arr[idx]);

        dfs(idx + 1, sum);
    }

    
}
