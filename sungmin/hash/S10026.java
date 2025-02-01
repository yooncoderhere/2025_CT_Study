import java.io.*;
import java.util.*;
import java.util.stream.*;

public class S10026 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        int length = Integer.parseInt(input.remove(0));
        int[][] grid = new int[length][length];
        for (int i = 0; i < input.size(); i++) {
            String row = input.get(i);
            for (int j = 0; j < row.length(); j++) {
                char c = row.charAt(j);
                if (c == 'G') {
                    grid[i][j] = 1;
                } else if (c == 'B') {
                    grid[i][j] = 2;
                }
            }
        }
        int normalCount = count(length, grid);

        grid = new int[length][length];
        for (int i = 0; i < input.size(); i++) {
            String row = input.get(i);
            for (int j = 0; j < row.length(); j++) {
                char c = row.charAt(j);
                if (c == 'B') {
                    grid[i][j] = 1;
                }
            }
        }
        int otherCount = count(length, grid);

        return normalCount + " " + otherCount;
    }

    private static int count(int length, int[][] grid) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] != -1) {
                    count++;
                    search(i, j, grid, grid[i][j]);
                }
            }
        }
        return count;
    }

    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static void search(int x, int y, int[][] grid, int target) {
        grid[x][y] = -1;

        for (int[] direction : directions) {
            int nextX = x + direction[0];
            int nextY = y + direction[1];
            if (nextX > -1 && nextX < grid.length
                && nextY > -1 && nextY < grid[0].length
                && grid[nextX][nextY] == target
            ) {
                search(nextX, nextY, grid, target);
            }
        }
    }
}
