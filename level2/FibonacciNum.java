package programmersProblum.level2;

public class FibonacciNum {
    public static void main(String[] args) {
        System.out.println(solution(50));
    }

    public static int solution(int n) {
        int answer = 0;
        int[] arr = new int[n + 1];
        for(int i=0; i< arr.length; i++){
            if(i<2)
                arr[i] = i;
            else
                arr[i] = (arr[i-1] + arr[i-2]) % 1234567;

        }

        return arr[arr.length-1];
    }

}

/*
    // 굳이 배열을 안만들고도 풀 수 있었다. 자원을 절약...!
    int num1 = 0, num2 = 1;
    for(int i=2; i< arr.length; i++){
        answer = (num1 + num2) % 1234567;
        num1 = num2;
        num2 = answer;
    }

* */
