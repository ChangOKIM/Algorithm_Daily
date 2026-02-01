import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int check = Integer.parseInt(br.readLine());
            if(check>25){
                System.out.println("Lower");
            }else if(check<25){
                System.out.println("Higher");
            }else{
                System.out.println("Good");
                break;
            }
        }
    }
}