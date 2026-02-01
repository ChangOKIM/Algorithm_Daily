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

        int cnt = 0;

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(arr[i][j]%5 == 0){
                    cnt +=1;
                }
            }
        }

        System.out.println(cnt);

        
    }
}