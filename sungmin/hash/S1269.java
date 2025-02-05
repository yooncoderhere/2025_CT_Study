import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class S1269 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        int[] left = Arrays.stream(input.get(1).split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] right = Arrays.stream(input.get(2).split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int result = left.length + right.length;

        Set<Integer> set = new HashSet<>();
        for (int num : left) {
            set.add(num);
        }
        for (int num : right) {
            if (set.remove(num)) {
                result = result - 2;
            }
        }

        return String.valueOf(result);
    }
}
