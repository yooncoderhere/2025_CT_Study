import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class S18870 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        int len = Integer.parseInt(input.get(0));
        StringTokenizer st = new StringTokenizer(input.get(1));
        int[][] nums = new int[len][];
        for (int i = 0; i < len; i++) {
            nums[i] = new int[] {Integer.parseInt(st.nextToken()), i};
        }

        Arrays.sort(nums, Comparator.comparingInt((int[] it) -> it[0]));

        int incrementer = 0;
        int pre = nums[0][0];
        nums[0][0] = 0;
        for (int i = 1; i < len; i++) {
            int[] num = nums[i];
            if (pre == num[0]) {
                num[0] = incrementer;
            } else {
                incrementer++;
                pre = num[0];
                num[0] = incrementer;
            }
        }

        Arrays.sort(nums, Comparator.comparingInt((int[] it) -> it[1]));
        StringBuilder b = new StringBuilder();
        for (int[] num : nums) {
            b.append(num[0]);
            b.append(' ');
        }
        return b.toString();
    }
}
