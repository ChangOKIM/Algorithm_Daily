import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int init = Integer.parseInt(br.readLine());

            if(init !=0){
                System.out.println(init);
            }else if(init == 0){
                break;
            }
        }
    }
}