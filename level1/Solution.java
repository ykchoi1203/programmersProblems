package programmersProblum.level1;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        long[] numbers = {3, 7};
        long[] answer = solution(numbers);
        for(long i : answer)
            System.out.println(i);

    }

    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i=0; i<numbers.length; i++){
            if(numbers[i]%2 == 0)
                answer[i] = numbers[i] + 1;
            else{
                long num = numbers[i];
                int cnt = 0;
                int max = -1;

                while(num > 0){
                    if(num%2 == 0 && max == -1){
                        max = cnt;
                        break;
                    }
                    cnt++;
                    num /= 2;
                }
                if(max == -1){
                    answer[i] = numbers[i] + (int)Math.pow((double) 2, (double) cnt) - (int)Math.pow((double) 2, (double) cnt);

                } else{

                }



            }
        }

        return answer;
    }

}
