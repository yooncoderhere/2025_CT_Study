import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// TODO 실패
public class S2283 {
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
        int target = Integer.parseInt(st.nextToken());
        int[] nums = new int[1_000_001];

        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 1; i < len+1; i++) {
            StringTokenizer st1 = new StringTokenizer(input.get(i));
            int l = Integer.parseInt(st1.nextToken());
            int r = Integer.parseInt(st1.nextToken());
            for (int j = l; j < r; j++) {
                nums[j]++;
            }
            min = Math.min(min, l);
            max = Math.max(max, r);
        }

        int l = min;
        int r = min;
        int sum = nums[min];
        int[] result = {1_000_000, 10_000_000};
        Comparator<int[]> comparator = Comparator.comparingInt((int[] it) -> it[0] + it[1])
                .thenComparingInt((int[] it) -> it[0])
                .thenComparingInt((int[] it) -> it[1]);
        while (true) {
            if (sum == target) {
                if (comparator.compare(result, new int[] {l, r+1}) > 0) {
                    result[0] = l;
                    result[1] = r+1;
                }
                sum = sum - nums[l];
                l++;
            } else if (sum < target) {
                r++;
                if (r == nums.length) {
                    break;
                }
                sum += nums[r];
            } else {
                sum = sum - nums[l];
                l++;
            }
        }
        if (result[0] == 1_000_000) {
            return "0 0";
        }

        // TODO 이부분때문에 계속 틀림 아직도 이해못함....
        //5 5
        //1 2
        //1 2
        //1 2
        //5 7
        //5 9
        //답 0 6
        if(result[0] == min) {
            result[0] = 0;
        }
        return result[0] + " " + result[1];
    }
}
