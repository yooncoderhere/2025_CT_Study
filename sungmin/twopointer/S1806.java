import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class S1806 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        StringTokenizer st = new StringTokenizer(input.get(0));
        int len = Integer.parseInt(st.nextToken());
        int targetSum = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(input.get(1));
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(st2.nextToken());
        }

        int partSum = 0;
        int l = 0;
        int r = -1;
        int minLen = Integer.MAX_VALUE;
        while (true) {
            if (partSum >= targetSum) {
                minLen = Math.min(minLen, r - l + 1);

                partSum = partSum - nums[l];
                l++;
                if (l > r) {
                    break;
                }
            } else {
                r++;
                if (r == len) {
                    break;
                }
                partSum = partSum + nums[r];
            }
        }

        return minLen == Integer.MAX_VALUE ? "0" : String.valueOf(minLen);
    }
}
