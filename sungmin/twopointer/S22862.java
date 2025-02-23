import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class S22862 {
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
        int modifyCount = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(input.get(1));
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(st1.nextToken());
        }

        int l = 0;
        int r = -1;
        int max = 0;
        int oddCount = 0;
        while (r < nums.length - 1) {
            r++;
            if (nums[r] % 2 == 1) {
                oddCount++;
            }

            if (oddCount <= modifyCount) {
                max = Math.max(max, r - l + 1 - oddCount);
            }

            while (oddCount > modifyCount) {
                if (nums[l] % 2 == 1) {
                    oddCount--;
                }
                l++;
            }
        }

        return String.valueOf(max);
    }
}
