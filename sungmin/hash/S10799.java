import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.stream.Collectors;

public class S10799 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        String s = input.get(0);

        int result = 0;
        boolean canOnRazor = true;
        int pipeCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                canOnRazor = true;
                pipeCount++;
            } else {
                if (canOnRazor) {
                    canOnRazor = false;
                    pipeCount--;
                    result = result + pipeCount;
                } else {
                    result++;
                    pipeCount--;
                }
            }
        }
        return String.valueOf(result);
    }
}
