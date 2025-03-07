import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class S2805 {
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
        int len = Integer.parseInt(st1.nextToken());
        long target = Long.parseLong(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(input.get(1));
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(nums);

        int l = 0;
        int r = Math.max(0, nums[nums.length - 1] - 1);
        int result = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            boolean big = isBig(nums, target, m);
            if (big) {
                result = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return String.valueOf(result);
    }

    static boolean isBig(int[] nums, long target, int height) {
        long sum = 0;
        for (int num : nums) {
            if (num > height) {
                sum += num - height;
                if (sum >= target) {
                    return true;
                }
            }
        }
        return false;
    }
}
