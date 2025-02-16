import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class S18258 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(solution(br.lines().collect(Collectors.toList())));
            br.close();
            bw.flush();
        }
    }

    public static String solution(List<String> input) {
        Queue<Integer> queue = new Queue<>();
        StringBuilder b = new StringBuilder();
        for (int i = 1; i < input.size(); i++) {
            String[] split = input.get(i).split("\\s+");
            switch (split[0]) {
                case "push":
                    queue.push(Integer.parseInt(split[1]));
                    break;
                case "pop":
                    b.append(convertNull(queue.pop()));
                    b.append('\n');
                    break;
                case "size":
                    b.append(queue.size);
                    b.append('\n');
                    break;
                case "empty":
                    b.append(queue.empty());
                    b.append('\n');
                    break;
                case "front":
                    b.append(convertNull(queue.front()));
                    b.append('\n');
                    break;
                case "back":
                    b.append(convertNull(queue.back()));
                    b.append('\n');
                    break;
                default:
                    throw new IllegalArgumentException("Invalid input: " + split[0]);
            }
        }
        return b.toString();
    }

    static int convertNull(Integer i) {
        if (i == null) {
            return -1;
        } else {
            return i;
        }
    }

    static class Queue<T> {
        Node<T> head;
        Node<T> tail;
        int size;
        void push(T value) {
            Node<T> node = new Node<>(value);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            size++;
        }

        T pop() {
            if (size == 0) {
                return null;
            }

            T value = head.value;
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
            size--;
            return value;
        }

        int empty() {
            return size == 0 ? 1 : 0;
        }

        T front() {
            if (size == 0) {
                return null;
            }
            return head.value;
        }

        T back() {
            if (size == 0) {
                return null;
            }
            return tail.value;
        }
    }

    static class Node<T> {
        T value;
        Node<T> next;
        public Node(T value) {
            this.value = value;
        }
    }
}
