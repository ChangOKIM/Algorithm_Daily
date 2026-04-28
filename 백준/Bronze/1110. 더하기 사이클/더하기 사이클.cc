#include <stdio.h>

int main(){
    int N, Initial, cnt=0;
    
    scanf("%d", &N);
    Initial = N;
    
    while(1){
        N = (N%10+N/10)%10 + N%10*10;
        cnt++;
        if(N==Initial){
            printf("%d", cnt);
            break;
        }
    }
    return 0;
    
}