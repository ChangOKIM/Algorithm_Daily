import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 3;
        int[][] arr1 = new int[3][3];
        int[][] arr2 = new int[3][3];
        int[][] result = new int[3][3];

        for(int i=0; i<N; i++){
            StringBuilder sb = new StringBuilder();
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            for(int j=0; j<N; j++){
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.readLine();
        for(int i=0; i<N; i++){
            StringBuilder sb = new StringBuilder();
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            for(int j=0; j<N; j++){
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                result[i][j] = arr1[i][j] * arr2[i][j];
            }
        }

        for(int i=0; i<N; i++){
            StringBuilder sb2 = new StringBuilder();
            for(int j=0; j<N; j++){
                sb2.append(result[i][j]).append(" ");
            }
            System.out.println(sb2);
        }
    }
}