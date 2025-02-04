import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class S2910 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    static class Counter {
        int index;
        int count = 1;
        Counter(int index) {
            this.index = index;
        }
    }

    public static String solution(List<String> input) {
        Map<Integer, Counter> map = new HashMap<>();
        String[] arr = input.get(1).split("\\s+");
        for (int i = 0; i < arr.length; i++) {
            int finalI = i;
            map.compute(Integer.parseInt(arr[i]), (k, v) -> {
                if (v == null) {
                     return new Counter(finalI);
                }
                v.count++;
                return v;
            });
        }

        // value index count

        StringBuilder b = new StringBuilder();
        map.entrySet().stream()
                .sorted(Comparator.comparingInt((Map.Entry<Integer, Counter> a) -> a.getValue().count)
                        .reversed()
                        .thenComparingInt((Map.Entry<Integer, Counter> a) -> a.getValue().index)
                )
                .forEach(entry -> {
                    for (int i = 0; i < entry.getValue().count; i++) {
                        b.append(entry.getKey());
                        b.append(' ');
                    }
                });

        return b.toString();
    }
}
