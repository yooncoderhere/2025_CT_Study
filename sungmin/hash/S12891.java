import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class S12891 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        int windowSize = Integer.parseInt(input.get(0).split("\\s+")[1]);
        String dnaStr = input.get(1);

        char[] needKey = {'A', 'C', 'G', 'T'};
        int[] needCounts = Arrays.stream(input.get(2).split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int totalNeedCounts = Arrays.stream(needCounts).sum();

        for (int i = 0; i < windowSize; i++) {
            for (int j = 0; j < needKey.length; j++) {
                if (needKey[j] == dnaStr.charAt(i)) {
                    needCounts[j]--;

                    if (needCounts[j] >= 0) {
                        totalNeedCounts--;
                    }
                    break;
                }
            }
        }

        int result = 0;
        if (totalNeedCounts == 0) {
            result++;
        }

        int l = 0;
        int r = windowSize;
        while (r < dnaStr.length()) {
            char removed = dnaStr.charAt(l);
            char added = dnaStr.charAt(r);
            if (added != removed) {
                for (int j = 0; j < needKey.length; j++) {
                    if (needKey[j] == added) {
                        needCounts[j]--;

                        if (needCounts[j] >= 0) {
                            totalNeedCounts--;
                        }
                    }
                    if (needKey[j] == removed) {
                        needCounts[j]++;

                        if (needCounts[j] > 0) {
                            totalNeedCounts++;
                        }
                    }
                }
            }

            l++;
            r++;
            if (totalNeedCounts == 0) {
                result++;
            }
        }

        return String.valueOf(result);
    }
}
