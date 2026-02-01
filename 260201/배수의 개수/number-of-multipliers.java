import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        int cnt_3 = 0;
        int cnt_5 = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<10; i++){
            int check = Integer.parseInt(br.readLine());
            if(check%3==0){
                cnt_3 +=1;
            }

            if(check%5==0){
                cnt_5 +=1;
            }

        }

        System.out.printf("%d %d", cnt_3, cnt_5);
    }
}