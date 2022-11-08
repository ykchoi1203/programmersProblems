package programmersProblum.level3;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class DoublePriorityQueue {
    public static void main(String[] args) {
        String[] arr = new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] arr2 = new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(Arrays.toString(solution(arr)));
        System.out.println(solution(arr2));
    }

    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> minNum = new PriorityQueue<>();
        PriorityQueue<Integer> maxNum = new PriorityQueue<>(Collections.reverseOrder());

        for(String s : operations){
            String[] str = s.split(" ");
            if(str[0].equals("I")){
                maxNum.add(Integer.parseInt(str[1]));
                minNum.add(Integer.parseInt(str[1]));
            } else {
                if(minNum.size() == 0 || maxNum.size() == 0)
                    continue;
                else if(str[1].equals("-1") && minNum.size() != 0){
                    maxNum.remove((minNum.poll()));
                } else if (str[1].equals("1") && maxNum.size() != 0){
                    minNum.remove(maxNum.poll());
                }
            }
        }
        if(minNum.size() == 0 && maxNum.size() == 0){
            return new int[] {0, 0};
        }
        return new int[] {maxNum.peek(), minNum.peek()};
    }

}
/* 큐 사용 안하고 푼 정답
        int[] answer = {};

        for(int i=0; i<operations.length; i++){
            String[] operate = operations[i].split(" ");
            if(operate[0].equals("I")){
                answer = pushNum(answer, Integer.parseInt(operate[1]));
            } else {
                answer = deleteNum(answer, Integer.parseInt(operate[1]));
            }
        }

        if(answer.length == 0)
            return new int[]{0, 0};


        return getAnswer(answer);
    }
    public static int[] pushNum(int[] arr, int num){
        int[] copyArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, copyArr, 0, arr.length);
        copyArr[arr.length] = num;
        return copyArr;
    }


    public static int[] deleteNum(int[] arr, int option){
        if(arr.length == 0)
            return arr;
        else if(arr.length == 1)
            return new int[0];


        if(option == 1){
            int max = arr[0];
            int maxAt = 0;
            for(int i = 1; i < arr.length; i++){
                if(max < arr[i]){
                    max = arr[i];
                    maxAt = i;
                }
            }

            int[] copyArr = new int[arr.length - 1];
            System.arraycopy(arr, 0, copyArr, 0, maxAt);
            System.arraycopy(arr, maxAt + 1, copyArr, maxAt, arr.length - maxAt -1);

            return copyArr;
        } else {
            int min = arr[0];
            int minAt = 0;
            for(int i = 1; i < arr.length; i++){
                if(min > arr[i]){
                    min = arr[i];
                    minAt = i;
                }
            }
            int[] copyArr = new int[arr.length - 1];
            System.arraycopy(arr, 0, copyArr, 0, minAt);
            System.arraycopy(arr, minAt + 1, copyArr, minAt, arr.length - minAt -1);

            return copyArr;
        }
    }

    public static int[] getAnswer (int[] arr){
        int max = arr[0], min = arr[0];

        for(int i=1; i<arr.length; i++){
            if(max < arr[i])
                max = arr[i];
            if(min > arr[i])
                min = arr[i];
        }

        return new int[] {max, min};
*/