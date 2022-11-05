package programmersProblum.level2;

import java.util.Arrays;

public class MaxNumAndMinNum {
    public static void main(String[] args) {
        System.out.println(solution("1 2 3 4"));
        System.out.println(solution("-4 -2 -3 -1"));
        System.out.println(solution("-1 -1"));
    }

    public static String solution(String s) {
        String[] num = s.split(" ");
        int[] arr = new int[num.length];


        for(int i = 0; i < num.length; arr[i] = Integer.parseInt(num[i++]));
        Arrays.sort(arr);

        return arr[0] + " " + arr[arr.length-1];
    }
}
