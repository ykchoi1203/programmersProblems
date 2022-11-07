package programmersProblum.level3;

public class NumberTriangle {
    public static void main(String[] args) {
        int[][] arr = {{7}, {3, 8}, {8,1,0}, {2,7,4,4}, {4,5,2,6,5}};
        System.out.println(solution(arr));
    }

    public static int solution(int[][] triangle) {
        for(int i = triangle.length-1; i>0; i--){
            for(int j = 0; j < triangle[i].length-1; j++){
                triangle[i][j] = triangle[i][j] <= triangle[i][j+1] ? triangle[i][j+1] : triangle[i][j];
            }
            for(int j = 0; j < triangle[i-1].length; j++){
                triangle[i-1][j] += triangle[i][j];
            }
        }

        return triangle[0][0];
    }

}
