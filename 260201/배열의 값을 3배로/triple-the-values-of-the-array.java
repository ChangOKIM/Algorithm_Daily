import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 3;
        int[][] arr1 = new int[3][3];
        for(int i=0; i<N; i++){
            String str = br.readLine();

            StringTokenizer st = new StringTokenizer(str);

            for(int j=0; j<N; j++){
                arr1[i][j] = Integer.parseInt(st.nextToken()) * 3;
            }
        }

        for(int i=0; i<N; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<N; j++){
                sb.append(arr1[i][j]).append(" ");
            }
            System.out.println(sb);
        }
        
    }
}