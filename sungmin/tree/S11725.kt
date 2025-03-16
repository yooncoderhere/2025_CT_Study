import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        BufferedWriter(OutputStreamWriter(System.out)).use { bw ->
            bw.write(S11725().solution(br.lines().collect(Collectors.toList())))
            br.close()
            bw.flush()
        }
    }
}

class S11725 {
    fun solution(input: List<String>): String {
        val len = input.first().toInt() + 1 // 0번째 인덱스는 사용하지 않음
        val arr = Array(len) { ArrayList<Int>() }
        for (i in 1 until input.size) {
            val st = StringTokenizer(input[i])
            val l = st.nextToken().toInt()
            val r = st.nextToken().toInt()
            arr[l].add(r)
            arr[r].add(l)
        }

        val visited = BooleanArray(len)
        val parents = IntArray(len)
        var queue: Queue<Int> = LinkedList()
        queue.add(1)
        while(queue.isNotEmpty()) {
            val nextQueue: Queue<Int> = LinkedList()
            while(queue.isNotEmpty()) {
                val parent = queue.poll()
                visited[parent] = true
                val children = arr[parent]
                for (c in children) {
                    if (!visited[c]) {
                        parents[c] = parent
                        nextQueue.add(c)
                    }
                }
            }
            queue = nextQueue
        }

        val b = StringBuilder()
        for (i in 2 until parents.size) {
            b.append(parents[i])
            b.append('\n')
        }
        return b.toString()
    }
}
