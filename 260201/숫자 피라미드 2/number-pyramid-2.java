import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int times = 1;
        for(int i=0; i<N; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<i+1; j++){
                sb.append(times).append(" ");
                times += 1;
            }
            System.out.println(sb);
        }
        
    }
}