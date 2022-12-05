package programmersProblum.level0;

import java.util.ArrayList;
import java.util.Arrays;

public class UnusualArrangement {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {10000, 20, 36, 47, 40, 6, 10, 7000}, 30)));
	}

	public static int[] solution(int[] numlist, int n) {
		int[] answer = {};
		ArrayList<Integer> al = new ArrayList<>();

		int idx = 0;
		numlist = Arrays.stream(numlist).sorted().toArray();
		for(int i=1; i<numlist.length; i++) {
			if(Math.abs(numlist[i] - n) <=  Math.abs(numlist[idx] - n)) {
				idx = i;
			}
			if(numlist[i] > n) break;
		}
		int leftIdx = idx - 1;
		int rightIdx = idx + 1;
		al.add(numlist[idx]);

		for(int i=0; i<numlist.length-1; i++) {
			if(leftIdx < 0) {
				al.add(numlist[rightIdx]);
				rightIdx++;
			} else if(rightIdx >= numlist.length) {
				al.add(numlist[leftIdx]);
				leftIdx++;
			}
			else if(Math.abs(numlist[leftIdx] - n) <  Math.abs(numlist[rightIdx] - n)) {
				al.add(numlist[leftIdx]);
				leftIdx++;
			} else {
				al.add(numlist[rightIdx]);
				rightIdx++;
			}
		}


		return al.stream().mapToInt(el -> el).toArray();
	}
}
