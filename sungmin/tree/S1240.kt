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
            bw.write(S1240().solution(br.lines().collect(Collectors.toList())))
            br.close()
            bw.flush()
        }
    }
}

class S1240 {
    fun solution(input: List<String>): String {
        val st1 = StringTokenizer(input.first())
        val nodeCount = st1.nextToken().toInt()

        val edges = Array(nodeCount + 1){ ArrayList<IntArray>() }
        for (i in 1 until nodeCount) {
            val st2 = StringTokenizer(input[i])
            val first = st2.nextToken().toInt()
            val second = st2.nextToken().toInt()
            val distance = st2.nextToken().toInt()

            edges[first].add(intArrayOf(second, distance))
            edges[second].add(intArrayOf(first, distance))
        }

        val b = StringBuilder()
        for (i in nodeCount until input.size) {
            val st3 = StringTokenizer(input[i])
            val start = st3.nextToken().toInt()
            val end = st3.nextToken().toInt()
            val distance: Int = search(start, end, edges)
            b.append(distance)
            b.append('\n')
        }
        return b.toString()
    }

    private fun search(start: Int, end: Int, edges: Array<ArrayList<IntArray>>): Int {
        val queue = LinkedList<IntArray>()
        for (edge in edges[start]) {
            // [<다음 탐색 노드>, <누적거리>, <현재노드-부모노드>]
            queue.add(intArrayOf(edge[0], edge[1], start))
        }

        while (queue.isNotEmpty()) {
            val c = queue.poll()
            val current = c[0]
            val distance = c[1]
            val parent = c[2]
            if (current == end) {
                return distance
            }

            for (nextNode in edges[current]) {
                val next = nextNode[0]
                if (next == parent) {
                    continue
                }

                val addedDistance = distance + nextNode[1]
                queue.add(intArrayOf(next, addedDistance, current))
            }
        }

        throw RuntimeException("can't here")
    }
}
