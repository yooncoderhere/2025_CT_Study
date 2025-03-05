import java.util.Arrays;

public class S128 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);

        int len = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                continue;
            } else if (nums[i - 1] + 1 != nums[i]) {
                len = Math.max(len, count);
                count = 1;
            } else {
                count++;
            }
        }
        len = Math.max(len, count);
        return len;
    }
}
