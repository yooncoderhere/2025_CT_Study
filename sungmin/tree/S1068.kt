import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.StringTokenizer
import java.util.stream.Collectors

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        BufferedWriter(OutputStreamWriter(System.out)).use { bw ->
            bw.write(S1068().solution(br.lines().collect(Collectors.toList())))
            br.close()
            bw.flush()
        }
    }
}

class S1068 {
    fun solution(input: List<String>): String {
        val len = input.first().toInt()
        val removeNode = input[2].toInt()
        val edges = Array(len) { ArrayList<Int>() }
        val st = StringTokenizer(input[1])
        var rootNode = -1
        for (i in 0 until len) {
            val parent = st.nextToken().toInt()
            if (parent == -1) {
                rootNode = i
            } else if (i != removeNode) {
                edges[parent].add(i)
            }
        }

        if (rootNode == removeNode) {
            return "0"
        }

        val queue = LinkedList<Int>()
        queue.add(rootNode)
        var count = 0
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (node == -1) {
                continue
            }

            val children = edges[node]
            if (children.isEmpty()) {
                count++
            } else {
                queue.addAll(children)
            }
        }

        return count.toString()
    }
}
