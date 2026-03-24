import java.util.*;

class Solution {
    ArrayDeque<Integer> queue;
    ArrayDeque<Integer> queueLocation;
    int[] locaBol;
    int answer;
    public int solution(int[] priorities, int location) {
        queue  = new ArrayDeque<>();
        queueLocation  = new ArrayDeque<>();
        answer = 0;
        locaBol = new int[priorities.length];
        locaBol[location] = 1;
        
        
        for(int i=0; i<priorities.length; i++){
            queue.add(priorities[i]);
            queueLocation.add(locaBol[i]);
        }
        
        while(true){
            int check = 0;
            for(int a : queue){
                if(a > check){
                    check = a;
                }
            }
            
            int isThis = queue.peekFirst();
            int isThisVal = queueLocation.peekFirst();
            if(isThis == check && isThisVal == 1){
                answer +=1;
                break;
            }else if(isThis == check){
                answer +=1;
                queue.pollFirst();
                queueLocation.pollFirst();
            }else{
                int temp1 = queue.pollFirst();
                queue.add(temp1);
                int temp2 = queueLocation.pollFirst();
                queueLocation.add(temp2);
            }
        }
        return answer;
    }
}