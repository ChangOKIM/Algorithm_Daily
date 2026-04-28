import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc1 = new Scanner(System.in);


        int A;
        A = sc1.nextInt();

        int B, b1, b2, b3;
        B = sc1.nextInt();
        b1 = B%10;
        b2 = (B%100)/10;
        b3 = B/100;
        

        System.out.println(A * b1);
        System.out.println(A * b2);
        System.out.println(A * b3);
        System.out.println(A * B);




    }
}