import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class S1655 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        PriorityQueue<Integer> leftQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>();
        leftQueue.add(Integer.MIN_VALUE);
        rightQueue.add(Integer.MAX_VALUE);

        StringBuilder b = new StringBuilder();
        for (int i = 1; i < input.size(); i++) {
            int num = Integer.parseInt(input.get(i));
            if (leftQueue.size() > rightQueue.size()) {
                if (leftQueue.peek() < num) {
                    rightQueue.add(num);
                } else {
                    rightQueue.add(leftQueue.poll());
                    leftQueue.add(num);
                }
            } else {
                rightQueue.add(num);
                leftQueue.add(rightQueue.poll());
            }

            b.append(leftQueue.peek());
            b.append('\n');
        }
        return b.toString();
    }
}
