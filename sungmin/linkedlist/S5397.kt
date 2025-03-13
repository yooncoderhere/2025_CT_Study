import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.ArrayList
import java.util.LinkedList
import java.util.stream.Collectors

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        BufferedWriter(OutputStreamWriter(System.out)).use { bw ->
            bw.write(S5397().solution(br.lines().collect(Collectors.toList())))
            br.close()
            bw.flush()
        }
    }
}

class S5397 {
    fun solution(input: List<String>): String {
        val b = StringBuilder()
        for (i in 1 until input.size) {
            b.append(run(input[i]))
            b.append('\n')
        }
        return b.toString()
    }

    fun run(line: String): String {
        val left = LinkedList<Char>()
        val right = LinkedList<Char>()
        for (c: Char in line) {
            if (c == '<') {
                if (left.isNotEmpty()) {
                    right.addFirst(left.removeLast())
                }
            } else if (c == '>') {
                if (right.isNotEmpty()) {
                    left.addLast(right.removeFirst())
                }
            } else if (c == '-') {
                if (left.isNotEmpty()) {
                    left.removeLast()
                }
            } else {
                left.addLast(c)
            }
        }

        val b = StringBuilder()
        for (c in left) {
            b.append(c)
        }
        for (c in right) {
            b.append(c)
        }
        return b.toString()
    }
}
