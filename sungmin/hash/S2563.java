import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class S2563 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        boolean[][] map = new boolean[100][100];
        for (int i = 1; i < input.size(); i++) {
            String[] split = input.get(i).split("\\s+");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);

            for (int r = x; r < x + 10; r++) {
                for (int c = y; c < y + 10; c++) {
                    map[r][c] = true;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j]) {
                    result++;
                }
            }
        }
        return String.valueOf(result);
    }
}
