import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class S1781 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    // TODO 시계를 거꾸로 흐르면서 해당시간에 하나씩 넣고 / 제일큰걸 뽑느다.
    // 데드라인 1 2 3 4 5
    //        2 - 5
    //        3 - 6
    //            7

    // 3에서 5/6/7중 -> 7 삭제
    // 2에서 5/6/중  -> 6 삭제
    // 1에서 2/3/5중 -> 5 삭제
    //             합 18
    public static String solution(List<String> input) {
        PriorityQueue<int[]> waitQueue = new PriorityQueue<>(Comparator.comparingInt((int[] it) -> it[0]).reversed());
        int clock = 0;
        for (int i = 1; i < input.size(); i++) {
            StringTokenizer st = new StringTokenizer(input.get(i));
            int[] e = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            waitQueue.add(e);
            clock = Math.max(clock, e[0]);
        }

        int result = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        while (clock > 0 && (!waitQueue.isEmpty() || !queue.isEmpty())) {
            while (!waitQueue.isEmpty() && waitQueue.peek()[0] == clock) {
                queue.add(waitQueue.poll()[1]);
            }

            if (!queue.isEmpty()) {
                result = result + queue.poll();
            }
            clock--;
        }

        return String.valueOf(result);
    }
}
