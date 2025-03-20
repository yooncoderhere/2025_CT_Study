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
            bw.write(S14267().solution(br.lines().collect(Collectors.toList())))
            br.close()
            bw.flush()
        }
    }
}

class S14267 {
    fun solution(input: List<String>): String {
        val st1 = StringTokenizer(input.first())
        val len = st1.nextToken().toInt()
        val praiseLen = st1.nextToken().toInt()
        val subs = Array(len+1) { ArrayList<Int>() }
        val st2 = StringTokenizer(input[1])
        var root = -1
        for (i in 1 .. len) {
            val parent = st2.nextToken().toInt()
            if (parent == -1) {
                root = i
                continue
            }
            subs[parent].add(i)
        }

        val praises = HashMap<Int, Int>()
        for (i in 2 until praiseLen+2) {
            val st3 = StringTokenizer(input[i])
            val person = st3.nextToken().toInt()
            val praiseAmount = st3.nextToken().toInt()
            if (person == 1) {
                continue
            }
            praises.compute(person) { _, v -> if (v == null) praiseAmount else v+praiseAmount }
        }

        val reducedPraise = IntArray(len+1)
        var queue = LinkedList<IntArray>()
        queue.add(intArrayOf(root, 0))
        while (queue.isNotEmpty()) {
            val nextQueue = LinkedList<IntArray>()
            while (queue.isNotEmpty()) {
                val poll = queue.poll()
                val person = poll[0]
                val preAmount = poll[1]
                val amount = praises.getOrDefault(person, 0) + preAmount
                reducedPraise[person] = amount
                for (sub in subs[person]) {
                    nextQueue.add(intArrayOf(sub, amount))
                }
            }
            queue = nextQueue
        }

        val b = StringBuilder()
        for (i in 1 until reducedPraise.size) {
            b.append(reducedPraise[i])
            b.append(' ')
        }
        return b.toString()
    }
}
