package programmersProblum.level3;

import java.util.Arrays;

public class WayToSchool {

    public static void main(String[] args) {
        System.out.println(solution(4, 3, new int[][]{{2, 1}, {1,3} }));
        System.out.println(solution(2, 2, new int[][]{{2,1}}));
    }

    public static int solution(int m, int n, int[][] puddles) {
        int[][] arr = new int[n][m];
        if (m * n - 2 <= puddles.length) return 0;

        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], 1);
        }

        for (int i = 0; i < puddles.length; i++) {
            arr[puddles[i][1] - 1][puddles[i][0] - 1] = 0;
        }

        for(int i = 0; i < m; i++) {
            if(arr[0][i] == 0) {
                for(int j=i; j<m; j++) {
                    arr[0][j] = 0;
                }
                break;
            }
        }

        for(int i = 1; i < n; i++) {
            if(arr[i][0] == 0) {
                for(int j=i; j<n; j++) {
                    arr[j][0] = 0;
                }
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[j][i] != 0) {
                    arr[j][i] = arr[j - 1][i] + arr[j][i - 1];
                }
            }
        }

        return arr[n - 1][m - 1];

//        return count(1, 1, m, n, puddles);
    }

    public static int count(int x, int y, int m, int n, int[][] puddles) {
        // 재귀로 풀어봄 -> 효율성에서 통과가 안됨
        for (int i = 0; i < puddles.length; i++) {
            if (puddles[i][0] == x && puddles[i][1] == y) return 0;
        }
        int result = 0;
        if (x == m && y == n) return 1;
        else if (x == m) {
            result += count(x, y + 1, m, n, puddles);
        } else if (y == n) {
            result += count(x + 1, y, m, n, puddles);
        } else {
            result += count(x + 1, y, m, n, puddles);
            result += count(x, y + 1, m, n, puddles);
        }

        return result;
    }
}
