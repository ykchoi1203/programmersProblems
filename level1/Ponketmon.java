package programmersProblum.level1;

import java.util.HashSet;

public class Ponketmon {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {3,3,3,2,2,4}));
        System.out.println(solution(new int[] {3,1,2,3}));
        System.out.println(solution(new int[] {3,3,3,2,2,2}));
    }

    public static int solution(int[] nums) {
        HashSet<Integer> sets = new HashSet<>();
        for(int i : nums)
            sets.add(i);
        if(nums.length/2 >= sets.size())
            return sets.size();
        else
            return nums.length/2;

    }
}
