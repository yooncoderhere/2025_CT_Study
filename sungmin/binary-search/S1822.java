import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class S1822 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        StringTokenizer st1 = new StringTokenizer(input.get(0));
        int len1 = Integer.parseInt(st1.nextToken());
        int len2 = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(input.get(1));
        StringTokenizer st3 = new StringTokenizer(input.get(2));

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len1; i++) {
            set.add(Integer.parseInt(st2.nextToken()));
        }

        for (int i = 0; i < len2; i++) {
            set.remove(Integer.parseInt(st3.nextToken()));
        }

        StringBuilder b = new StringBuilder();
        b.append(set.size());
        b.append('\n');
        set.stream().sorted().forEach(n -> {
            b.append(n);
            b.append(' ');
        });

        return b.toString();
    }
}
