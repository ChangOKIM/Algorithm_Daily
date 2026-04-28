import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nums = Integer.parseInt(br.readLine());
		
		int init = 2;
		int arr_max = Integer.MIN_VALUE;
		int arr_min = Integer.MAX_VALUE;
		ArrayList<Integer> arr = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		for(int i=0; i<nums; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i=0; i<nums; i++) {
			if(arr.get(i) > arr_max) arr_max = arr.get(i);
			if(arr.get(i) < arr_min) arr_min = arr.get(i);
		}
		

		System.out.println(arr_max*arr_min);
		
	}
}

