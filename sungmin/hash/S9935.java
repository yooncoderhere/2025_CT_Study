import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class S9935 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        String bomb = input.get(1);
        String s = input.get(0);
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            list.add(c);

            if (list.size() >= bomb.length()) {
                boolean isEqual = true;
                for (int j = 0; j < bomb.length(); j++) {
                    Character c1 = list.get(list.size() - bomb.length() + j);
                    char c2 = bomb.charAt(j);
                    if (c2 != c1) {
                        isEqual = false;
                        break;
                    }
                }

                if (isEqual) {
                    for (int j = 0; j < bomb.length(); j++) {
                        list.remove(list.size() - 1);
                    }
                }
            }
        }

        if (list.isEmpty()) {
            return "FRULA";
        } else {
            StringBuilder b = new StringBuilder(list.size());
            for (Character c : list) {
                b.append(c);
            }
            return b.toString();
        }
    }
}
