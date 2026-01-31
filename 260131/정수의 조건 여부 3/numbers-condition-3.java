import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();

        if(a%13 == 0 || a%19 == 0){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }
}