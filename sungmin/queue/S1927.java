import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class S1927 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < input.size(); i++) {
            int num = Integer.parseInt(input.get(i));
            if (num == 0) {
                if (queue.isEmpty()) {
                    answer.append(num);
                } else {
                    answer.append(queue.poll());
                }
                answer.append('\n');
            } else {
                queue.add(num);
            }
        }

        return answer.toString();
    }
}
