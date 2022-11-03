package programmersProblum.level1;

import java.util.Arrays;
import java.util.Stack;

public class MakeBurger {
    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(solution(arr));

    }

    private static int solution(int[] arr) {
        int answer = 0;
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < arr.length) {
            stack.push(arr[i]);
            i++;
            if (stack.size() > 3) {
                if (stack.peek() == 1) {
                    int[] isBurger = new int[4];
                    int[] burger = {1, 3, 2, 1};
                    for (int j = 0; j < isBurger.length; j++) {
                        isBurger[j] = stack.pop();
                    }
                    if (isEquals(burger, isBurger)) {
                        answer++;
                    } else {
                        for (int j = isBurger.length - 1; j >= 0; j--) {
                            stack.push(isBurger[j]);
                        }
                    }
                }
            }

        }


        return answer;
    }

    private static boolean isEquals(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }


    // 첫번째 방법.. 테스트 12번에서 시간초과 ingeredient 가 길어지면 시간이 부족한듯...
    /*public static int solution(int[] ingredient) {
        int answer = 0;
        int i = 0;
        int last = ingredient.length - 3;
        while(i < last){
            if(ingredient[i] != 1){
                i++;
            } else if (ingredient[i+1] != 2) {
                i++;
            } else if (ingredient[i+2] != 3) {
                i++;
            } else if (ingredient[i+3] != 1) {
                i++;
            } else {
                int[] arr = new int[ingredient.length-4];
                if(i != 0)
                    System.arraycopy( ingredient, 0, arr, 0, i);
                if(i+3 < ingredient.length)
                    System.arraycopy(ingredient, i+4, arr, i,  ingredient.length-(i+4));
                if(i == 0)
                    i = 0;
                else if (i==1)
                    i = 0;
                else if (i==2)
                    i=0;
                else
                    i -= 3;
                answer ++;
                ingredient = arr;
                last = ingredient.length - 3;
            }

        }


        return answer;
    }*/

}
