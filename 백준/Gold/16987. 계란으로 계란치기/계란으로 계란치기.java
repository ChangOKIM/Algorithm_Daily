import java.util.*;
import java.io.*;


public class Main {
    static int N, ans;
    static int[][] arr;
   // static int[] state;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ans = 0;
        arr = new int[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(ans);
        
    }

    static void dfs(int depth){
        if(depth == N){ 
            int broken = 0;
            for(int i=0; i<N; i++){
                if(arr[i][0] <= 0) broken++;
            }
            if(broken>ans) ans = broken;
            return;
        }

        if(arr[depth][0] <= 0){
            dfs(depth + 1);
            return;
        }

        boolean hit = false;
        for(int i=0; i<N; i++){
            if(i==depth) continue;
            if(arr[i][0]>0){
                hit = true;

                arr[depth][0] -= arr[i][1];
                arr[i][0] -= arr[depth][1];

                dfs(depth+1);

                arr[depth][0] += arr[i][1];
                arr[i][0] += arr[depth][1];

            }
        }
        if(!hit) dfs(depth+1);
    }
}

