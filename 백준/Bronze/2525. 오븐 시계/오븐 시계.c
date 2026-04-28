#include <stdio.h>

int main(){
    int A, B, C;
    
    scanf("%d %d\n", &A, &B);
    scanf("%d", &C);
    
    if(B+C<60)
        printf("%d %d", A, B+C);
    else
        printf("%d %d", (A+((B+C)/60))%24, (B+C)%60);
    return 0;
}