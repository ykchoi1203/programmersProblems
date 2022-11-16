package programmersProblum.level1;

public class FindPrimeNumber {
    public static void main(String[] args) {
        System.out.println(solution(10000000));
    }

    public static int solution(int n) {
        int answer = 0;
        boolean[] arr = new boolean[n+1];
        boolean b=true;

        arr[2] = true;
        for(int i=3; i<arr.length; i+=2){
            b = true;
            for(int j=3; j<=Math.sqrt(i); j+=2){
                if(arr[j]){
                    if(i%j == 0){
                        b = false;
                        break;
                    }
                }
            }
            if(b){
                arr[i] = true;
                answer++;
            }
        }
        return ++answer;
    }
}
