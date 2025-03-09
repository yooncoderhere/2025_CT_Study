import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        BufferedWriter(OutputStreamWriter(System.out)).use { bw ->
            bw.write(S18869().solution(br.lines().collect(Collectors.toList())))
            br.close()
            bw.flush()
        }
    }
}

class S18869 {
    fun solution(input: List<String>): String {
        val st1 = StringTokenizer(input[0])
        val rowLen = st1.nextToken().toInt()
        val colLen = st1.nextToken().toInt()

        val map = mutableMapOf<List<Int>, Int>()
        for (i in 1..rowLen) {
            val st = StringTokenizer(input[i])
            val pairs = ArrayList<Int>(colLen)
            val indexMap = HashMap<Int, Int>(colLen)
            for (j in 0 until colLen) {
                val num = st.nextToken().toInt()
                pairs.add(num)
                indexMap.put(num, j)
            }

            pairs.sort()
            for (j in 0 until colLen) {
                pairs[j] = indexMap[pairs[j]]!!
            }

            map.compute(pairs) { _, v -> if (v == null) 1 else v + 1 }
        }

        var preSum = 1
        var pre = 2
        var r = 0
        map.values
            .filter { it > 1 }
            .sorted()
            .forEach({
                run {
                    if (it != pre) {
                        preSum = rangeSum(preSum, pre, it)
                        pre = it
                    }
                    r += preSum
                }
            })

        return r.toString()
    }


    private fun rangeSum(preSum: Int, pre: Int, n: Int): Int {
        var sum = preSum
        for (v in pre until n) {
            sum += v
        }
        return sum
    }
}
