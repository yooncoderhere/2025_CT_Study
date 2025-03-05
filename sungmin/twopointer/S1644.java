import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class S1644 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        int n = Integer.parseInt(input.get(0));
        if (n == 1) {
            return "0";
        } else if (n < 4) {
            return "1";
        }

        List<Integer> primeList = primeList(n);

        int l = 0;
        int r = 0;
        int partSum = primeList.get(0);
        int count = 0;
        while (l <= r) {
            if (partSum == n) {
                count++;
                l++;
                r++;
                if (r == primeList.size()) {
                    break;
                }
                partSum = partSum - primeList.get(l-1) + primeList.get(r);
            } else if (partSum > n) {
                partSum = partSum - primeList.get(l);
                l++;
            } else {
                r++;
                if (r == primeList.size()) {
                    break;
                }
                partSum = partSum + primeList.get(r);
            }
        }

        return String.valueOf(count);
    }

    // TODO 아리토네스체 안써서 계속 시간초과 발생
    static List<Integer> primeList(int max) {
        boolean[] visited = new boolean[max + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= max; i++) {
            if (!visited[i]) {
                list.add(i);
                for (int j = i; j <= max; j = j + i) {
                    visited[j] = true;
                }
            }
        }
        return list;
    }
}
