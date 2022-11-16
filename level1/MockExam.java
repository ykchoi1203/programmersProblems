package programmersProblum.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class MockExam {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {5,4,4,2,1})));
    }
    public static int[] solution(int[] answers) {
        int[] answer = {};
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,1,2,3,2,4,2,5};
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;

        for(int i=0; i<answers.length; i++){
            if(answers[i] == arr1[i%5])
                cnt1++;
            if(answers[i] == arr2[i%8])
                cnt2++;
            if(answers[i] == arr3[i%10])
                cnt3++;
        }

        int maxCorrect = cnt1;
        if(maxCorrect < cnt2)
            maxCorrect = cnt2;
        if(maxCorrect < cnt3)
            maxCorrect = cnt3;

        ArrayList<Integer> list = new ArrayList<>();
        if(maxCorrect == cnt1)
            list.add(1);
        if(maxCorrect == cnt2)
            list.add(2);
        if(maxCorrect == cnt3)
            list.add(3);

        answer = list.stream().mapToInt(m -> m).toArray();

        return answer;
    }

}
