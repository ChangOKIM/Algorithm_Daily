import java.io.*;
import java.util.*;


public class Main {
	static String s;
	static StringTokenizer st;
	static StringBuilder sb;
	static StringBuilder sb2;
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = br.readLine();
		boolean isIn = false;
		sb = new StringBuilder();
		sb2 = new StringBuilder();
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c == '<') {
				isIn = true;
				if(sb2.length()>0) {
					for(int j=sb2.length()-1; j>=0; j--) {
						sb.append(sb2.charAt(j));
					}
					sb2 = new StringBuilder();
				}
			}
			
			if(isIn) {
				sb.append(c);
			}else {
				if(c - '0' != -16) {
					sb2.append(c);
				}else {
					if(sb2.length()>0) {
						for(int j=sb2.length()-1; j>=0; j--) {
							sb.append(sb2.charAt(j));
						}
						sb2 = new StringBuilder();
					}
					
					sb.append(" ");
				}
			}
			
			if(c == '>') {
				isIn = false;
			}
		}
		
		if(sb2.length()>0) {
			for(int j=sb2.length()-1; j>=0; j--) {
				sb.append(sb2.charAt(j));
			}
			sb2 = new StringBuilder();
		}
		
		System.out.println(sb);
	}
}