import java.io.*;
import java.util.*;
import java.util.stream.*;

public class S14425 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        String[] split = input.get(0).split(" ");
        int count1 = Integer.parseInt(split[0]);
        int count2 = Integer.parseInt(split[1]);

        Set<String> set1  = new HashSet<>();
        for (int i = 1; i < 1 + count1; i++) {
            set1.add(input.get(i));
        }

        int count = 0;
        for (int i = 1 + count1; i < 1 + count1 + count2; i++) {
            if (set1.contains(input.get(i))) {
                count++;
            }
        }
        return String.valueOf(count);
    }
}
