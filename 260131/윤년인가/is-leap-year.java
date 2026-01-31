import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int Y = Integer.parseInt(br.readLine());

        if(Y%4==0){
            if(Y%100==0 && Y%400 !=0){
                System.out.println("false");
            }else{
                System.out.println("true");
            }
        }else{
            System.out.println("false");
        }

    }
}