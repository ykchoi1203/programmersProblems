package programmersProblum.level3;

import java.util.Arrays;

public class NumberGame {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {5,3,1,2}, new int[] {2,2,6,8}));
    }

    public static int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=A.length-1, j=B.length-1; i>=0; i--) {
            if(A[i] < B[j]) {
                answer++;
                j--;
            }
        }

//         List<Integer> aList = Arrays.stream(A).boxed().collect(Collectors.toList());
//         List<Integer> bList = Arrays.stream(B).boxed().collect(Collectors.toList());

//         Collections.sort(aList, Collections.reverseOrder());
//         Collections.sort(bList, Collections.reverseOrder());

//         while(!bList.isEmpty()) {
//             if(aList.get(0) < bList.get(0)){
//                 bList.remove(0);
//                 aList.remove(0);
//                 answer++;
//             } else {
//                 bList.remove(bList.size()-1);
//                 aList.remove(0);
//             }
//         }


        return answer;
    }
}
