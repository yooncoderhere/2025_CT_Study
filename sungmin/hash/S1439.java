import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.stream.Collectors;

public class S1439 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        char[] charArray = input.get(0).toCharArray();

        char targetChar = charArray[0];
        char pre = charArray[0];
        int result = 0;
        for (int i = 1; i < charArray.length; i++) {
            char c = charArray[i];
            if (c != pre) {
                if (c != targetChar) {
                    result++;
                }
                pre = c;
            }
        }
        return String.valueOf(result);
    }
}
