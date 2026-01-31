import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int init = 1;
        int sum = 0;

        while(true){
            sum += init;
            if(sum>=N){
                break;
            }
            init +=1;
            
        }

        System.out.println(init);

    }
}