import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class S1806_2 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    // TODO 왼쪽에서 부터 하나씩 더해가면서 목표를 넘어서는 순간 길이를 정답과 비교하여 짧으면 갱신한다
    //  0- [5] 1 3 5 10 7 4 9 2 8 -> 5 < 15
    //  1- [5 1] 3 5 10 7 4 9 2 8 -> 6 < 15
    //  2- [5 1 3] 5 10 7 4 9 2 8 -> 9 < 15
    //  3- [5 1 3 5] 10 7 4 9 2 8 -> 14 < 15
    //  4- [5 1 3 5 10] 7 4 9 2 8 -> 24 > 15 -> 답 5로 갱신
    //     5 [1 3 5 10] 7 4 9 2 8 -> 19 > 15 -> 답 4로 갱신
    //     5 1 [3 5 10] 7 4 9 2 8 -> 18 > 15 -> 답 3로 갱신
    //     5 1 3 [5 10] 7 4 9 2 8 -> 15 = 15 -> 답 2로 갱신
    //     5 1 3 5 [10] 7 4 9 2 8 -> 10 < 15
    //  5- 5 1 3 5 [10 7] 4 9 2 8 -> 17 > 15 -> 2 답으로 갱신안함 이미 2임
    public static String solution(List<String> input) {
        StringTokenizer st0 = new StringTokenizer(input.get(0));
        int len = Integer.parseInt(st0.nextToken());
        int target = Integer.parseInt(st0.nextToken());
        StringTokenizer st1 = new StringTokenizer(input.get(1));
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(st1.nextToken());
        }

        int l = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            sum = sum+nums[i];
            while (sum >= target) {
                result = Math.min(result, i - l + 1);
                sum = sum - nums[l];
                l++;
            }
        }

        return result == Integer.MAX_VALUE ? "0" : String.valueOf(result);
    }
}
