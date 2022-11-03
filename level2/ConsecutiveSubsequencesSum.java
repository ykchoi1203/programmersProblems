package programmersProblum.level2;

import java.util.HashSet;

public class ConsecutiveSubsequencesSum {
    public static void main(String[] args) {
        int[] elements = {7, 9, 1, 1, 4};
        System.out.println(solution(elements));
    }


    public static int solution(int[] elements) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        int length = elements.length;
        int[] ansArray = new int[2*length];
        System.arraycopy(elements, 0, ansArray, 0, length);
        System.arraycopy(elements, 0, ansArray, length, length);

        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
                int add = 0;
                for(int k = 0; k <=i; k++){
                    add += ansArray[j+k];
                }
                set.add(add);
            }
        }
        answer = set.size();

        return answer;
    }
}
