import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringTokenizer st = new StringTokenizer(str);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr1 = new int[N][M];
        int[][] arr2 = new int[N][M];
        int[][] result = new int[N][M];

        for(int i=0; i<N*2; i++){
            String input = br.readLine();
            st = new StringTokenizer(input);
            if(i<N){
                for(int j=0; j<M; j++){
                    arr1[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            else{
                for(int j=0; j<M; j++){
                    arr2[i-N][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr1[i][j] == arr2[i][j]){
                    result[i][j] = 0;
                }else{
                    result[i][j] = 1;
                }
            }
        }

        for(int i=0; i<N; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<M; j++){
                sb.append(result[i][j]).append(" ");
            }
            System.out.println(sb);
        }

    }
}