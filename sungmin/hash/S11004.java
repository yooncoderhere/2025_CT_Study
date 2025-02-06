import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class S11004 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        int targetIndex = Integer.parseInt(input.get(0).split("\\s+")[1]);
        int[] array = Arrays.stream(input.get(1).split("\\s+"))
                .mapToInt(Integer::parseInt)
                .sorted()
                .limit(targetIndex)
                .toArray();
        return String.valueOf(array[array.length - 1]);
    }
}
