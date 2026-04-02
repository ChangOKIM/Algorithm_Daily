import java.util.*;

class Solution {
    static int[] answer;
    public int[] solution(int[] answers) {
        
        int[] person1 = new int[10001];
        int[] person2 = new int[10001];
        int[] person3 = new int[10001];
        
        int[] person1Cycle = {1, 2, 3, 4, 5};
        int[] person2Cycle = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3Cycle = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int totalCnt = 0;
        int firstCnt = 0;
        int secondCnt = 0;
        int thridCnt = 0;
        while(totalCnt<10001){
            person1[totalCnt] = person1Cycle[firstCnt];
            person2[totalCnt] = person2Cycle[secondCnt];
            person3[totalCnt] = person3Cycle[thridCnt];
            totalCnt++;
            firstCnt++;
            secondCnt++;
            thridCnt++;
            if(firstCnt == 5){
                firstCnt = 0;
            }
            if(secondCnt == 8){
                secondCnt = 0;
            }
            if(thridCnt == 10){
                thridCnt = 0;
            }
        }
        
        int answer1 = 0;
        int answer2 = 0;
        int answer3 = 0;
        
        for(int i=0; i<answers.length; i++){
            if(answers[i] == person1[i]){
                answer1++;
            }
            if(answers[i] == person2[i]){
                answer2++;
            }
            if(answers[i] == person3[i]){
                answer3++;
            }
        }
        //정답 배열은 크기를 모르는데 도출되는 정답을 리스트에 넣어서 리스트를 다시 배열화하는 과정이 항상 필요한가?
        int maxAnswer = Math.max(answer1, answer2);
        maxAnswer = Math.max(maxAnswer, answer3);
        
        ArrayList<Integer> result = new ArrayList<>();
        
        if(answer1 == maxAnswer) result.add(1);
        if(answer2 == maxAnswer) result.add(2);
        if(answer3 == maxAnswer) result.add(3);
        
        answer = new int[result.size()];
    
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}