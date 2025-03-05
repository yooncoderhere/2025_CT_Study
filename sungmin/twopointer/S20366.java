import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// TODO 답보고 배낌
public class S20366 {
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
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        // TODO 실패1. 외부합 vs 내부합
        // TODO 실패2. 왼쪽끝2개의 차이 vs 오른쪽끝 2개의 차이 차이가 큰쪽으로
        // TODO 그냥 전부 순회해야함?
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+3; j < nums.length; j++) {
                int outerSum = nums[i] + nums[j];
                int l = i+1;
                int r = j-1;
                while (l < r) {
                    int sum = nums[l] + nums[r];
                    if (sum == outerSum) {
                        return "0";
                    } else if (sum < outerSum) {
                        min = Math.min(min, outerSum - sum);
                        l++;
                    } else {
                        min = Math.min(min, sum - outerSum);
                        r--;
                    }
                }
            }
        }
        return String.valueOf(min);
    }
}
