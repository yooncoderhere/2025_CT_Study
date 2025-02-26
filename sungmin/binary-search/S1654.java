import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class S1654 {
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
        int count = Integer.parseInt(st1.nextToken());
        int[] nums = new int[len];
        for (int i = 1; i < len+1; i++) {
            nums[i-1] = Integer.parseInt(input.get(i));
        }
        Arrays.sort(nums);

        int l = 1;
        int r = nums[nums.length - 1];
        while (l+1 < r) {
            int m = l + (r - l)/2;
            int devidedCount = devide(nums, m);
            if (devidedCount >= count) {
                l = m;
            } else {
                r = m - 1;
            }
        }

        if (devide(nums, r) >= count) {
            return String.valueOf(r);
        }
        return String.valueOf(l);
    }

    private static int devide(int[] nums, int len) {
        int count = 0;
        for (int num : nums) {
            count = count + (num / len);
        }
        return count;
    }
}
