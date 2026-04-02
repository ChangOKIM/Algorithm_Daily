import java.util.*;

class Solution {
    static int answer;
    static boolean[] isPrime;
    static char[] temp;
    static boolean[] visited;
    static HashSet<Integer> primes;
    static char[] c;
    
    public int solution(String numbers) {
        //에라토스테네스의 체 부분
        isPrime = new boolean[10000000];
        isPrime[0] = true;
        isPrime[1] = true;
        
        for(int i=2; i<(int)Math.sqrt(10000000); i++){
            if(!isPrime[i]){
                for(int j=i*i; j<10000000; j += i){
                    isPrime[j] = true;
                }
            }
        }
        
        //numbers각각을 배열에 넣는 부분
        c = new char[numbers.length()];
        for(int i=0; i<numbers.length(); i++){
            c[i] = numbers.charAt(i);
        }
        
        primes = new HashSet<>();        
        
        //dfs하는데 depth를 i만큼 정해서 돌게끔
        for(int i=1; i<=numbers.length(); i++){
            temp = new char[i];
            visited = new boolean[numbers.length()];
            dfs(0);
        }
        answer = primes.size();
        return answer;
    }
    
    static void dfs(int depth){
        if(temp.length == depth){
            int num = makeNumber(); //숫자화 하는거
            checkPrime(num); //isPrime에 있으면 set에 넣기(중복 제거)
            return;
        }
        
        for(int i=0; i<c.length; i++){
            if(!visited[i]){
                visited[i] = true;
                temp[depth] = c[i];
                dfs(depth + 1);
                visited[i] = false;
            }
            
        }
    }
    
    static int makeNumber(){
        return Integer.parseInt(new String(temp));
    }
    
    static void checkPrime(int num){
        if(!isPrime[num]){
            primes.add(num);
        }
    }
}