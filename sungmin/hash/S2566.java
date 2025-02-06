import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.stream.Collectors;

public class S2566 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        int max = -1;
        int x = -1;
        int y = -1;

        for (int i = 0; i < input.size(); i++) {
            String[] row = input.get(i).split("\\s+");
            for (int j = 0; j < row.length; j++) {
                int n = Integer.parseInt(row[j]);
                if (max < n) {
                    max = n;
                    x = i;
                    y = j;
                }
            }
        }
        return max + "\n" + (x + 1) + " " + (y + 1);
    }
}
