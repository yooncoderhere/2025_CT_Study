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
            bw.write(S4803().solution(br.lines().collect(Collectors.toList())))
            br.close()
            bw.flush()
        }
    }
}

class S4803 {
    fun solution(input: List<String>): String {
        val b = StringBuilder()
        var index = 0
        var caseNumber = 1
        while(input[index] != "0 0") {
            val st1 = StringTokenizer(input[index])
            index++
            val nodeCount = st1.nextToken().toInt()
            val edgeCount = st1.nextToken().toInt()
            // edges 간선들 [0노드 간선, 1노드 간선]
            // edge 간선   [간선식별자, 연결된노드번호]
            val edges = Array(nodeCount+1) { ArrayList<IntArray>() }
            for (i in 0 until  edgeCount) {
                val st2 = StringTokenizer(input[index + i])
                val first = st2.nextToken().toInt()
                val second = st2.nextToken().toInt()
                edges[first].add(intArrayOf(i, second))
                edges[second].add(intArrayOf(i, first))
            }
            val treeCount = treeCount(nodeCount, edgeCount, edges)

            val p = output(caseNumber, treeCount)
            b.append(p)
            b.append('\n')

            caseNumber++
            index += edgeCount
        }
        return b.toString()
    }

    private fun treeCount(nodeCount: Int, edgeCount: Int, edges: Array<ArrayList<IntArray>>): Int {
        val visited = BooleanArray(nodeCount+1)
        val usedEdge = BooleanArray(edgeCount)
        var count = 0
        for (initNode in 1 .. nodeCount) {
            if (visited[initNode]) {
                continue
            }

            val edgeQueue = LinkedList<Int>()
            for (initEdge in edges[initNode]) {
                usedEdge[initEdge[0]] = true
                edgeQueue.add(initEdge[1])
            }

            var hasCycle = false
            while(edgeQueue.isNotEmpty()) {
                val node = edgeQueue.poll()
                if (visited[node]) {
                    hasCycle = true
                    continue
                }
                visited[node] = true

                val nextEdges = edges[node]
                for (nextEdge in nextEdges) {
                    val edgeId = nextEdge.first()
                    if (usedEdge[edgeId]) {
                        continue
                    }
                    usedEdge[edgeId] = true
                    edgeQueue.add(nextEdge[1])
                }
            }
            if (!hasCycle) {
                count++
            }
        }
        return count
    }

    private fun output(caseNumber: Int, count: Int): String {
        if (count == 0) {
            return "Case $caseNumber: No trees."
        } else if (count == 1) {
            return "Case $caseNumber: There is one tree."
        } else {
            return "Case $caseNumber: A forest of $count trees."
        }
    }
}
