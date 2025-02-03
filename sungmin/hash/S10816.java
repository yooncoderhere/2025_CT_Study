import java.io.*;
import java.util.*;
import java.util.stream.*;

public class S10816 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        List<String> list = Arrays.asList(input.get(1).split("\\s+"));
        Map<Integer, Integer> countMap = new HashMap<>();
        for (String l : list) {
            countMap.compute(Integer.parseInt(l), (k, v) -> v == null ? 1 : v + 1);
        }

        String[] target = input.get(3).split("\\s+");
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < target.length; i++) {
            b.append(countMap.getOrDefault(Integer.parseInt(target[i]), 0));
            if (i < target.length - 1) {
                b.append(' ');
            }
        }
        return b.toString();
    }
}
