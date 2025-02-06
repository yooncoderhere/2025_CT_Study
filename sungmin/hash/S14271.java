import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class S14271 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static String solution(List<String> input) {
        String[] str = input.get(0).split("\\s+");
        int rLen = Integer.parseInt(str[0]);
        int cLen = Integer.parseInt(str[1]);
        int time = Integer.parseInt(input.get(rLen + 1));

        // o-살았음 / .-죽었음
        // true-살았음 / false-죽었음
        boolean[][] map = new boolean[rLen + time + time][cLen + time + time];

        List<int[]> survive = new ArrayList<>();
        for (int i = 1; i < input.size(); i++) {
            String row = input.get(i);
            int x = i - 1 + time;
            for (int j = 0; j < row.length(); j++) {
                char c = row.charAt(j);
                int y = j + time;
                if (c == 'o') {
                    survive.add(new int[]{x, y});
                }
            }
        }

        int surviveCount = 0;
        for (int i = 0; i < time + 1; i++) {
            List<int[]> nextSurvive = new ArrayList<>();
            for (int[] point : survive) {
                if (map[point[0]][point[1]]) {
                    continue;
                }

                map[point[0]][point[1]] = true;
                surviveCount++;
                for (int[] direction : directions) {
                    int x = point[0] + direction[0];
                    int y = point[1] + direction[1];
                    if (x > -1 && x < map.length &&
                        y > -1 && y < map[0].length &&
                        !map[x][y]
                    ) {
                        nextSurvive.add(new int[]{x, y});
                    }
                }
            }
            survive = nextSurvive;
        }

        return String.valueOf(surviveCount);
    }
}
