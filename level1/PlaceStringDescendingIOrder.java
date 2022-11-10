package programmersProblum.level1;

public class PlaceStringDescendingIOrder {
    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg"));

    }
    public static String solution(String s) {
        String answer = "";
        String[] arr = s.split("");
        String temp;
        for(int i=0; i<arr.length-1; i++){
            for(int j=1+i; j<arr.length; j++){
                if(arr[i].compareTo(arr[j]) < 0){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(String k : arr)
            answer += k;

        return answer;
    }
}
