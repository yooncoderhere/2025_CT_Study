import java.util.HashMap;
import java.util.Map;

public class S3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> count = new HashMap<>();
        count.put(s.charAt(0), 1);

        int len = 1;
        int l = 0;
        int r = 0;
        while (r < s.length() - 1) {
            r++;
            char c = s.charAt(r);
            count.compute(c, (k, v) -> v == null ? 1 : v + 1);
            if (count.get(c) == 1) {
                len = Math.max(len, r - l + 1);
            } else {
                while(l <= r && count.get(c) > 1) {
                    count.compute(s.charAt(l), (k, v) -> v - 1);
                    l++;
                }
            }
        }
        return len;
    }
}
