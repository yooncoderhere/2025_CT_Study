import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class S16401 {
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
        StringTokenizer st2 = new StringTokenizer(input.get(1));
        int children = Integer.parseInt(st1.nextToken());
        int len = Integer.parseInt(st1.nextToken());
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(nums);

        int startIndex = Math.max(0, len - children);
        int endIndex = len - 1;

        int r = nums[len - 1];
        int l = endIndex - startIndex == children ? nums[startIndex] : Math.max(nums[len-1]/children, 1);
        while(l+1 < r) {
            int m = l + ((r - l) / 2);
            int count = count(startIndex, endIndex, m, nums);
            if (count >= children) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        if (count(startIndex, endIndex, r, nums) >= children) {
            return String.valueOf(r);
        }
        if (count(startIndex, endIndex, l, nums) >= children) {
            return String.valueOf(l);
        }
        return "0";
    }

    static int count(int s, int e, int pieceSize, int[] nums) {
        int count = 0;
        for (int i = s; i < e + 1; i++) {
            count = count + (nums[i] / pieceSize);
        }
        return count;
    }
}
