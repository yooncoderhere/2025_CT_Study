import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.stream.Collectors;

// TODO 못풀어서 답봄
public class S2023 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }
    public static String solution(List<String> input) {
        int n = Integer.parseInt(input.get(0));

        int[] firstDigits = {2, 3, 5, 7};

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < firstDigits.length; i++) {
            StringBuilder b = new StringBuilder();
            b.append(firstDigits[i]);
            search(firstDigits[i], n, b, result);
        }
        return result.toString();
    }

    static int[] lastDigits = {1, 3, 7, 9};
    private static void search(int preNumber, int maxCount, StringBuilder b, StringBuilder result) {
        if (b.length() == maxCount) {
            result.append(b);
            result.append('\n');
            return;
        }
        for (int lastDigit : lastDigits) {
            int next = (preNumber * 10) + lastDigit;
            if (isPrime(next)) {
                StringBuilder append = new StringBuilder(b).append(lastDigit);
                search(next, maxCount, append, result);
            }
        }
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i < (number / 2) + 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
