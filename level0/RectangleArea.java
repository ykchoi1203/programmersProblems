package programmersProblum.level0;

public class RectangleArea {
    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{1,1}, {2,1}, {2,2}, {1,2}}));
        System.out.println(solution(new int[][] {{-1,-1}, {-1,1}, {1,-1}, {1,1}}));
    }

    public static int solution(int[][] dots) {
        int answer = 0;
        int startWidth = dots[0][0];
        int endWidth = dots[0][0];
        int startHeight = dots[0][1];
        int endHeight = dots[0][1];

        for(int i=1; i<3; i++){
            if(startWidth != dots[i][0])
                endWidth = dots[i][0];
            if(startHeight != dots[i][1])
                endHeight = dots[i][1];
        }

        answer = Math.abs(startWidth - endWidth) * Math.abs(startHeight - endHeight);


        return answer;
    }
}
