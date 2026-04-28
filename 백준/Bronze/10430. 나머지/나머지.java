import java.util.*;

public class Main{
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int a, b, c;

        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        int result1, result2, result3, result4;

        result1 = (a + b)%c;
        result2 = ((a%c) + (b%c))%c;
        result3 = (a*b)%c;
        result4 = ((a%c)*(b%c))%c;

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);

    }
}