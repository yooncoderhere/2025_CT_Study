import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class S13414 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i < input.size(); i++) {
            String number = input.get(i);
            map.compute(number, (k, v) -> v == null ? 1 : v + 1);
        }

        StringBuilder b = new StringBuilder();
        int capacity = Integer.parseInt(input.get(0).split("\\s+")[0]);
        for (int i = 1; i < input.size(); i++) {
            String number = input.get(i);
            Integer count = map.compute(number, (k, v) -> v - 1);
            if (count == 0) {
                capacity--;
                b.append(number);
                b.append("\n");
            }
            if (capacity == 0) {
                break;
            }
        }

        return b.toString();
    }
}
