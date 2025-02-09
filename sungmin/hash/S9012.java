import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class S9012 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        StringBuilder b = new StringBuilder();
        for (int i = 1; i < input.size(); i++) {
            String s = input.get(i);
            int leftCount = 0;
            boolean invalid = false;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '(') {
                    leftCount++;
                } else {
                    leftCount--;
                    if (leftCount < 0) {
                        invalid = true;
                        break;
                    }
                }
            }
            if (leftCount > 0) {
                invalid = true;
            }
            if (invalid) {
                b.append("NO\n");
            } else {
                b.append("YES\n");
            }
        }
        return b.toString();
    }
}
