import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class S2230 {
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
        st.nextToken();
        int minDiff = Integer.parseInt(st.nextToken());

        int[] nums = new int[input.size() - 1];
        for (int i = 1; i < input.size(); i++) {
            int num = Integer.parseInt(input.get(i));
            nums[i - 1] = num;
        }
        Arrays.sort(nums);

        int l = 0;
        int r = 0;

        int diff = Integer.MAX_VALUE;
        while (r < nums.length) {
            int curDiff = nums[r] - nums[l];
            if (curDiff == minDiff) {
                diff = curDiff;
                break;
            } else if (curDiff < minDiff) {
                r++;
            } else {
                diff = Math.min(diff, curDiff);
                l++;
            }
        }

        return String.valueOf(diff);
    }
}
