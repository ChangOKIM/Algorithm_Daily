import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int [N][N];

        for(int i=1; i<N+1; i++){
            if(i%2 == 1){
                for(int j=0; j<N; j++){
                    arr[j][i-1] = j+1;
                }
            }else{
                for(int j=0; j<N; j++){
                    arr[N-j-1][i-1] = j+1;
                }
            }
        }

        for(int i=0; i<N; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<N; j++){
                sb.append(arr[i][j]);
            }
            System.out.println(sb);
        }
    }
}