import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arrN, arrM;
    static StringTokenizer st;
    static HashMap<Integer, Integer> check; //<키: 배열의 숫자, 밸류: 횟수>
    public static void main(String[] args) throws Exception{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arrN = new int[N];
        arrM = new int[M];

        check = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<arrN.length; i++){
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<arrN.length; i++){
            if(check.containsKey(arrN[i])){
                check.put(arrN[i], check.get(arrN[i]) + 1);
            }else{
                check.put(arrN[i], 1);
            }
        }

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<arrM.length; i++){
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<arrM.length; i++){
            System.out.print(check.getOrDefault(arrM[i], 0));
            System.out.print(" ");
        }

    }
}