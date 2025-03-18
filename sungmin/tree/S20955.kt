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
            bw.write(S20955().solution(br.lines().collect(Collectors.toList())))
            br.close()
            bw.flush()
        }
    }
}

class S20955 {
    fun solution(input: List<String>): String {
        val st1 = StringTokenizer(input.first())
        val len = st1.nextToken().toInt()
        val edgeLen = st1.nextToken().toInt()
        val edges = Array(len+1) { ArrayList<IntArray>() }
        for (i in 0 until edgeLen) {
            val st2 = StringTokenizer(input[i + 1])
            val l = st2.nextToken().toInt()
            val r = st2.nextToken().toInt()
            edges[l].add(intArrayOf(i, r))
            edges[r].add(intArrayOf(i, l))
        }

        val visited = BooleanArray(len+1)
        val usedEdge = BooleanArray(edgeLen)
        var count = -1
        for (initNode in 1 .. len) {
            if (visited[initNode]) {
                continue
            }

            var queue = LinkedList<Int>()
            queue.add(initNode)
            while (queue.isNotEmpty()) {
                val nextQueue = LinkedList<Int>()
                while (queue.isNotEmpty()) {
                    val node = queue.poll()
                    if (visited[node]) {
                        count++
                        continue
                    }

                    visited[node] = true
                    val nextNodes = edges[node]
                    for (nextNode in nextNodes) {
                        val edgeId = nextNode[0]
                        if (usedEdge[edgeId]) {
                            continue
                        }
                        usedEdge[edgeId] = true

                        val next = nextNode[1]
                        if (visited[next]) {
                            count++
                        } else {
                            nextQueue.addLast(next)
                        }
                    }

                }
                queue = nextQueue
            }

            count++
        }

        return count.toString()
    }
}
