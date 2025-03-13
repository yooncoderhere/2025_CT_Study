import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayDeque

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        BufferedWriter(OutputStreamWriter(System.out)).use { bw ->
            bw.write(S1158().solution(br.lines().collect(Collectors.toList())))
            br.close()
            bw.flush()
        }
    }
}

class S1158 {
    fun solution(input: List<String>): String {
        val st = StringTokenizer(input[0])
        val len = st.nextToken().toInt()
        val interval = st.nextToken().toInt()

        val queue: Queue<Int> = java.util.ArrayDeque<Int>()
        for (i in 1 .. len) {
            queue.add(i)
        }

        for (i in 1 until interval) {
            queue.add(queue.poll())
        }
        val b = StringBuilder()
        b.append('<')
        b.append(queue.poll())

        while (queue.isNotEmpty()) {
            for (i in 1 until interval) {
                queue.add(queue.poll())
            }
            b.append(',')
            b.append(' ')
            b.append(queue.poll())
        }
        b.append('>')

        return b.toString()
    }
}
