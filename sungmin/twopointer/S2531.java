import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class S2531 {
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
        int sushiVariation = Integer.parseInt(st.nextToken());
        int conti = Integer.parseInt(st.nextToken());
        int couponPlate = Integer.parseInt(st.nextToken());

        int[] plates = new int[len];
        for (int i = 0; i < len; i++) {
            plates[i] = Integer.parseInt(input.get(i+1));
        }

        int[] count = new int[3001];
        count[couponPlate] = -50000;
        int variation = 0;
        for (int i = 0; i < conti; i++) {
            int plate = plates[i];
            count[plate]++;
            if (count[plate] == 1) {
                variation++;
            }
        }

        int max = variation;
        for (int i = 0; i < len - 1; i++) {
            int remove = plates[i];
            count[remove]--;
            if (count[remove] == 0) {
                variation--;
            }

            int addIndex = i + conti >= len ? i + conti - len : i + conti;
            int add = plates[addIndex];
            count[add]++;
            if (count[add] == 1) {
                variation++;
            }
            max = Math.max(max, variation);
        }

        return String.valueOf(max + 1);
    }
}
