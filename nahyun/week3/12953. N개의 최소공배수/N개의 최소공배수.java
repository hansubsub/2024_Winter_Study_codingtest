import java.io.*;
import java.util.*;

class Solution {
    public static int solution(int[] arr) {
        int Length = arr.length;
        int answer = 0;
        for(int i = 0; i < Length-1; i++) {
            int gcd = GCD(arr[i], arr[i+1]);
            answer = arr[i] * arr[i+1] / gcd;
            arr[i+1] = answer;
        }
        return answer;
    }
    
    //최소 공약수
    public static int GCD(int A, int B) {
        if(B == 0) return A;
        else return GCD(B, A % B);
    }
    
}
