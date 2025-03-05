import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// TODO 못풀어서 요거 보고 배낌... https://tussle.tistory.com/1035
public class S13144 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }
    
    // 1 2 2 2 1
    // ^ ^       1~2 2개, 2 1개
    //     ^     2 1개
    //       ^ ^ 2~1 2개, 1 1개
    public static String solution(List<String> input) {
        StringTokenizer st = new StringTokenizer(input.get(1));
        int[] nums = new int[Integer.parseInt(input.get(0))];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        long count = 0;
        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            map.compute(num, (k, v) -> v == null ? 1 : v + 1);

            while (map.get(num) > 1) {
                count = count + right - left;
                map.compute(nums[left], (k, v) -> v == null ? -1 : v - 1);
                left++;
            }
        }

        while (left < nums.length) {
            count = count + nums.length - left;
            left++;
        }
        return String.valueOf(count);
    }
}
