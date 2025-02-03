import java.io.*;
import java.util.*;
import java.util.stream.*;

public class S10815 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(input.get(1).split("\\s+")));

        StringBuilder b = new StringBuilder();
        String[] numbers = input.get(3).split("\\s+");
        for (int i = 0; i < numbers.length; i++) {
            if (set.contains(numbers[i])) {
                b.append('1');
            } else {
                b.append('0');
            }

            if (i != numbers.length - 1) {
                b.append(' ');
            }
        }
        return b.toString();
    }
}
