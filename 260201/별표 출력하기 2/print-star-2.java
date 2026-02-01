import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=i; j<N; j++){
                sb.append("*").append(" ");
            }
            System.out.println(sb);
        }
    }
}