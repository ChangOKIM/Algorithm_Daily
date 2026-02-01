import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char check = br.readLine().charAt(0);

        String[] strr = {"apple", "banana", "grape", "blueberry", "orange"};
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<5; i++){
            if(strr[i].charAt(2)==check || strr[i].charAt(3)==check){
                cnt +=1;
                System.out.println(strr[i]);
            }
        }

        System.out.println(cnt);


    }
}