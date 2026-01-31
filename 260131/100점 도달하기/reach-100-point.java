import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();


        while(N <101){
            if(N<60){
                sb.append("F").append(" ");
                N +=1;
            }else if(60<= N && N<70){
                sb.append("D").append(" ");
                N +=1;
            }else if(70<= N && N<80){
                sb.append("C").append(" ");
                N +=1;
            }else if(80<= N && N<90){
                sb.append("B").append(" ");
                N +=1;
            }else if(90<= N){
                sb.append("A").append(" ");
                N +=1;
            }
        }

        System.out.println(sb.substring(0,sb.length()-1));


    }
}