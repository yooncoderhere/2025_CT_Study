import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S3015 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            // 혹시나 시간초과가 이것떄문인가? 해서 List로 받던걸 Stream 그대로 받도록 변경
            bw.write(solution(br.lines()));
            br.close();
            bw.flush();
        }
    }

    // 2    4    1      2      2        5       1
    // X    2    4      1/4    2/4      2/2/4   5
    // [2]  [4]  [4,1]  [4,2]  [4,2,2]  [5]     [5,1]
    public static String solution(Stream<String> input) {
        List<Integer> heights = input
                .skip(1)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // TODO 40% 시간초과 개선
        //      ArrayList -> int[]
        int[] arr = new int[heights.size()];
        int endIndex = -1;
        long count = 0;
        for (int i = 0; i < heights.size(); i++) {
            Integer height = heights.get(i);
            // TODO 58% 시간초과 순차적으로 전부탐색 -> 정렬된것으로 이진탐색
            count = count + count(height, arr, endIndex);

            while (endIndex != -1 && arr[endIndex] < height) {
                endIndex--;
            }
            endIndex++;
            arr[endIndex] = height;
        }
        return String.valueOf(count);
    }

    static long count(int height, int[] arr, int endIndex) {
        int l = 0;
        int r = endIndex; // -1
        while (l < r) {
            int m = ((l + r) / 2) + 1;
            if (height >= arr[m]) {
                r = m - 1;
            } else {
                l = m;
            }
        }

        if (r < 0) {
            return 0L;
        }
        int m = (l + r) / 2;
        return endIndex - m + 1L;
    }
}
