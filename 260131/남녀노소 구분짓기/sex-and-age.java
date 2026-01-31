import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sex = Integer.parseInt(br.readLine());

        int age = Integer.parseInt(br.readLine());

        if(sex == 0){
            if(age>=19){
                System.out.println("MAN");
            }else
                System.out.println("BOY");
        }else{
            if(age>=19){
                System.out.println("WOMAN");
            }else{
                System.out.println("GIRL");
            }
        }

    }
}