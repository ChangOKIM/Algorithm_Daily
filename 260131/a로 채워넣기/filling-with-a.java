import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        System.out.print(input.charAt(0) + "a" + input.substring(2,input.length()-2) + "a" + input.charAt(input.length()-1));
    }
}