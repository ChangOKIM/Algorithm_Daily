import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st= new StringTokenizer(str);

        String word1 = st.nextToken();
        String word2 = st.nextToken();

        if(word1.length() > word2.length()){
            System.out.print(word1 +" " + word1.length());
        }else if(word1.length() < word2.length()){
            System.out.print(word2 +" "+ word2.length());
        }else{
            System.out.print("same");
        }

    }
}