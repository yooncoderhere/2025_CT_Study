import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class S1715 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < input.size(); i++) {
            pq.add(Integer.parseInt(input.get(i)));
        }

        int result = 0;
        while (pq.size() > 1) {
            int added = pq.poll() + pq.poll();
            result = result + added;
            pq.add(added);
        }
        return String.valueOf(result);
    }
}
