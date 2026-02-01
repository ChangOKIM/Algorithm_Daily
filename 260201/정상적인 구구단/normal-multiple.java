import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<N+1; i++){
            StringBuilder sb = new StringBuilder();
            String result = "";
            for(int j=1; j<N+1; j++){
                sb.append(i + " * " + j + " = " + i*j).append(",").append(" ");
                result = sb.substring(0,sb.length()-2);
            }
            System.out.println(result);
        }
    }
}