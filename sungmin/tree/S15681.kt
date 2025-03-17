import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import java.util.stream.Collectors

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        BufferedWriter(OutputStreamWriter(System.out)).use { bw ->
            bw.write(S15681().solution(br.lines().collect(Collectors.toList())))
            br.close()
            bw.flush()
        }
    }
}

class S15681 {
    fun solution(input: List<String>): String {
        val st1 = StringTokenizer(input.first())
        val nodeCount = st1.nextToken().toInt()
        val root = st1.nextToken().toInt()
//        val queryCount = st1.nextToken().toInt()

        val edges = Array(nodeCount+1) { ArrayList<Int>() }
        for (i in 1 until nodeCount) {
            val st2 = StringTokenizer(input[i])
            val first = st2.nextToken().toInt()
            val second = st2.nextToken().toInt()
            edges[first].add(second)
            edges[second].add(first)
        }

        val answers = IntArray(nodeCount + 1)
        answers[root] = childrenCount(edges, 0, root, answers)

        val b = StringBuilder()
        for (i in nodeCount until input.size) {
            val query = input[i].toInt()
            b.append(answers[query])
            b.append('\n')
        }

        return b.toString()
    }

    private fun childrenCount(edges: Array<ArrayList<Int>>, parent: Int, node: Int, answers: IntArray): Int {
        var count = 1
        for (edge in edges[node]) {
            if (edge == parent) {
                continue
            }
            val childrenCount = childrenCount(edges, node, edge, answers)
            count += childrenCount
        }

        answers[node] = count
        return count
    }
}
