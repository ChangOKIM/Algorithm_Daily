import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[4][4];
        

        for(int i=0; i<4; i++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            for(int j=0; j<4; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<4; i++){
            int sum = 0;
            for(int j=0; j<4; j++){
                sum += arr[i][j];
            }

            System.out.println(sum);
        }
    }
}