package programmersProblum.level1;

import java.util.Arrays;
import java.util.TreeSet;

public class TakeTwoAndAdd {
    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1, 0, 0};
        System.out.println(Arrays.toString(solution(numbers)));

    }


    public static int[] solution(int[] numbers) {
        // 배운 내용으로만 풀기.
        // 테스트 케이스 속도 : 0.34ms ~ 3.28ms, 메모리 : 70MB ~ 80MB
//        int[] answer = new int[numbers.length * (numbers.length - 1) / 2];
//        int cnt = 0;
//        for(int i=0; i<numbers.length-1; i++){
//            for(int j=i+1; j<numbers.length; j++){
//                int sum = numbers[i] + numbers[j];
//                if(!hasNum(answer, sum, cnt)){
//                    answer[cnt] = sum;
//                    cnt++;
//                }
//            }
//        }
//        answer = Arrays.copyOf(answer, cnt);
//        Arrays.sort(answer);
//
//        return answer;
//    }
//
//    public static boolean hasNum(int[] arr, int num, int cnt){
//        for(int i=0; i<cnt; i++){
//            if(arr[i] == num)
//                return true;
//        }
//        return false;
//    }
//}

         // HashSet : 중복 없는 배열 느낌, 순서 없이 저장.
         // 테스트 케이스 속도 : 0.29ms ~ 1.17ms, 메모리 : 74MB ~ 81MB
//         int[] answer;
//         HashSet<Integer> answerSet = new HashSet<>();
//
//         for(int i=0; i<numbers.length-1; i++){
//             for(int j=i+1; j<numbers.length; j++){
//                 answerSet.add(numbers[i] + numbers[j]);
//             }
//         }
//         ArrayList<Integer> sortList = new ArrayList<>(answerSet);
//         answer = new int[sortList.size()];
//         Collections.sort(sortList);  // ArrayList -> sort -> Array
//                                      // ArrayList -> Array -> sort
//                                      // Collections.sort(list) 가 Arrays.sort(array) 보다 속도가 더 빠른듯?
//         int j=0;
//         for(int i : sortList){
//             answer[j] = i;
//             j++;
//         }
//         //Arrays.sort(answer);
//         return answer;
//      }
//}

    // TreeSet 은 HashSet 과 다르게 순서가 있지만 중복 X
    // 테스트 케이스 속도 : 0.52 ~ 2.81ms, 메모리 : 72 ~ 88MB
//    public int[] solution(int[] numbers) {
        int[] answer;
        TreeSet<Integer> ts = new TreeSet<>();

        for(int i=0; i<numbers.length - 1; i++){
            for(int j=i+1; j < numbers.length; j++){
                ts.add(numbers[i] + numbers[j]);
            }
        }
        answer = new int[ts.size()];
        int i = 0;
        for(int num : ts){
            answer[i] = num;
            i++;
        }
        return answer;
    }
}
