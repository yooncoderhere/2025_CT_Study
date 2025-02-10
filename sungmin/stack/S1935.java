import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class S1935 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        Stack<Double> stack = new Stack<>();
        String s = input.get(1);

        double[] numbers = new double[26];
        for (int i = 2; i < input.size(); i++) {
            numbers[i - 2] = Double.parseDouble(input.get(i));
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+') {
                stack.add(stack.pop() + stack.pop());
            } else if (c == '-') {
                stack.add(0 - stack.pop() + stack.pop());
            } else if (c == '*') {
                stack.add(stack.pop() * stack.pop());
            } else if (c == '/'){
                Double right = stack.pop();
                Double left = stack.pop();
                stack.add(left / right);
            } else {
                int numberIndex = c - 'A';
                stack.add(numbers[numberIndex]);
            }
        }

        return String.format("%.2f", stack.pop());
    }
}