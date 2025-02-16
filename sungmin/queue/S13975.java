import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class S13975 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < input.size(); i = i + 2) {
            String[] split = input.get(i).split("\\s+");
            if (split.length == 1) {
                sb.append("0\n");
                continue;
            }

            PriorityQueue<Long> queue = new PriorityQueue<>();
            for (String s : split) {
                queue.add(Long.parseLong(s));
            }

            long result = 0;
            while (queue.size() > 1) {
                long add = queue.poll() + queue.poll();
                queue.add(add);
                result = result + add;
            }

            sb.append(result);
            sb.append('\n');
        }
        return sb.toString();
    }
}
