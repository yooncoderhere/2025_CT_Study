import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class S2075 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        int len = Integer.parseInt(input.get(0));
        int[][] map = new int[len][len];
        for (int i = 1; i < input.size(); i++) {
            StringTokenizer st = new StringTokenizer(input.get(i));
            for (int j = 0; j < len; j++) {
                map[i-1][j] = Integer.parseInt(st.nextToken());
            }
        }

        // int[] {열번호, 행번호} 숫자 내림차순으로 정렬
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt((int[] it) -> map[it[0]][it[1]]).reversed());
        for (int i = 0; i < len; i++) {
            queue.add(new int[]{len-1, i});
        }

        for (int i = 0; i < len-1; i++) {
            int[] poll = queue.poll();
            int x = poll[0] - 1;
            int y = poll[1];

            if (x >= 0) {
                queue.add(new int[]{x, y});
            }
        }
        int[] answer = queue.poll();
        return String.valueOf(map[answer[0]][answer[1]]);
    }

    public static String solution2(List<String> input) {
        int len = Integer.parseInt(input.get(0));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 1; i < input.size(); i++) {
            StringTokenizer st = new StringTokenizer(input.get(i));
            for (int j = 0; j < len; j++) {
                int num = Integer.parseInt(st.nextToken());
                queue.add(num);
            }
        }

        for (int i = 0; i < len - 1; i++) {
            queue.poll();
        }
        return String.valueOf(queue.poll());
    }
}
