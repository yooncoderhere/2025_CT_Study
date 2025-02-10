import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class S1874 {
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
        Stack<Integer> stack = new Stack<>();
        int sequence = 1;

        boolean hasResult = true;
        for (int i = 1; i < input.size(); i++) {
            int num = Integer.parseInt(input.get(i));

            while (num > sequence) {
                stack.push(sequence);
                sequence++;
                sb.append("+\n");
            }

            if (num == sequence) {
                sequence++;
                sb.append("+\n-\n");
            } else if (stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
            } else {
                hasResult = false;
                break;
            }
        }
        return hasResult ? sb.toString() : "NO";
    }
}
