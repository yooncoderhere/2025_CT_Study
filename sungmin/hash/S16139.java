import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// TODO 못풀어서 답봄
public class S16139 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) throws IOException {
        String targetStr = input.get(0);
        char[] charArray = targetStr.toCharArray();

        int alphaLen = 'z' - 'a' + 1;
        int[][] cache = new int[targetStr.length()][alphaLen];
        cache[0][charArray[0] - 'a'] = 1;

        for (int i = 1; i < charArray.length; i++) {
            for (int j = 0; j < alphaLen; j++) {
                cache[i][j] = cache[i - 1][j];
            }
            int c = charArray[i] - 'a';
            cache[i][c] = cache[i][c] + 1;
        }

        StringBuilder b = new StringBuilder();
        for (int i = 2; i < input.size(); i++) {
            // TODO split 쓰면 72% 에서 효율성 실패 / StringTokenizer 사용하면 100점 통과 이게 맞냐?
            StringTokenizer st= new StringTokenizer(input.get(i));
            int c = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
//            String[] question = input.get(i).split("\\s+");
//            int c = question[0].charAt(0) - 'a';
//            int l = Integer.parseInt(question[1]);
//            int r = Integer.parseInt(question[2]);

            int count = cache[r][c];
            if (l != 0) {
                count = count - cache[l - 1][c];
            }
            b.append(count);
            b.append('\n');

        }
        return b.toString();
    }
}
