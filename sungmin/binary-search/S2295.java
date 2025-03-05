import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// TODO 3중 for문 했으나 통과하네...
public class S2295 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        int[] nums = input.stream()
                .skip(1)
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        for (int i = nums.length - 1; i > 0; i--) {
            Integer targetSum = nums[i];
            boolean exist = existThreeSum(targetSum, i - 1, nums);
            if (exist) {
                return String.valueOf(targetSum);
            }
        }
        new RuntimeException("not exit answer");
        return "";
    }

    static boolean existThreeSum(int targetSum, int endIndex, int[] nums) {
        for (int i = 0; i <= endIndex; i++) {
            int remainF = targetSum - nums[i];
            for (int j = 0; j <= endIndex; j++) {
                int remain = remainF - nums[j];
                if (remain <= 0) {
                    continue;
                }

                boolean has = search(remain, endIndex, nums);
                if (has) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean search(int target, int endIndex, int[] nums) {
        int l = 0;
        int r = endIndex;
        while (l < r) {
            int m = l + (r - l)/2;
            if (nums[m] == target) {
                return true;
            }else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return nums[l] == target;
    }
}
