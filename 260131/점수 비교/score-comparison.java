import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.

        Scanner sc = new Scanner(System.in);

        int A_math = sc.nextInt();
        int A_eng = sc.nextInt();
        int B_math = sc.nextInt();
        int B_eng = sc.nextInt();

        if(A_math>B_math && A_eng>B_eng){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }
}