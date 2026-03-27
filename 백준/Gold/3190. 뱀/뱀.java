import java.io.*;
import java.util.*;


public class Main {
	static int N, K;
	static ArrayList<int[]> appleList;
	static int L;
	static ArrayList<String[]> directionList;
	static ArrayDeque<int[]> snake;
	static StringTokenizer st;
	static String D;
	static int[] head;
	static int times;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		appleList = new ArrayList<>();
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			appleList.add(new int[] {x, y});
		}
		
		directionList = new ArrayList<>();
		
		L = Integer.parseInt(br.readLine());
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			String at = st.nextToken();
			String direction = st.nextToken();
			
			directionList.add(new String[] {at, direction});
		}
		
		D = "d";
		head = new int[] {1, 1};
		snake = new ArrayDeque<>();
		int[] headCopy = head.clone();
		snake.add(headCopy);
		times = 0;
		
		while(true) {
			times +=1;
			
//			//snake좀 보자
//			StringBuilder sb = new StringBuilder();
//			for(int[] bodys : snake) {
//				sb.append(Arrays.toString(bodys)).append(" ");
//			}
//			System.out.println(sb);
			
			
			//방향에따른
			if(D.equals("d")) {
				//머리 위치 변화
				head[1] +=1;			
			}else if(D.equals("a")) {
				head[1] -= 1;
			}else if(D.equals("s")) {
				head[0] +=1;
			}else if(D.equals("w")) {
				head[0] -=1;
			}
			
			
			//머리통이 범위 밖이면 아웃(벽)
			if(head[0] >N || head[1] >N || head[0] <1 || head[1] <1) {
				break;
			}
			
			for (int[] bodys : snake) {
			    if(bodys[0] == head[0] && bodys[1] == head[1]) {
			        System.out.println(times);
			        return;
			    }
			}

			//for문으로 사과 있는 곳인지 체크
			boolean isApple = false;
			int idxCheck = 0;
			for(int[] apple: appleList) {
				if(head[0] == apple[0] && head[1] == apple[1]) {
					isApple = true;
					break;
				}
				idxCheck +=1;
			}

			if(isApple) {
				//사과 있는 곳에 머리통 있으면 꼬리 남기기 = pollFirst안하고 add만
				int[] headCopy2 = head.clone();
				snake.add(headCopy2);
				//사과도 제거하기
				appleList.remove(idxCheck);
			}else {
				snake.pollFirst();
				int[] headCopy3 = head.clone();
				snake.add(headCopy3);
			}
			
			
			
			for(String[] position : directionList) {
				if(times == Integer.parseInt(position[0])) {
					if(position[1].equals("L")) {
						if(D.equals("d")) {
							D = "w";
						}else if(D.equals("a")) {
							D = "s";
						}else if(D.equals("s")) {
							D = "d";
						}else if(D.equals("w")) {
							D = "a";
						}
					}else if(position[1].equals("D")) {
						if(D.equals("d")) {
							D = "s";
						}else if(D.equals("a")) {
							D = "w";
						}else if(D.equals("s")) {
							D = "a";
						}else if(D.equals("w")) {
							D = "d";
						}
					}
				}
			}
			
			
		}
		
		System.out.println(times);
		
		
	}
}