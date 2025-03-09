import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import java.util.stream.Collectors

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        BufferedWriter(OutputStreamWriter(System.out)).use { bw ->
            bw.write(S2143().solution(br.lines().collect(Collectors.toList())))
            br.close()
            bw.flush()
        }
    }
}

// TODO
//  1. 두배열 모두 누적합을 구한다
//   1 3 1 2 -> 1 4 5 7
//   1 3 2   -> 1 4 6
//  2. 두번째 누적합[1 4 6]의 모든 경우의 수를 map에 저장한다 (key: 누적합, value: 빈도수)
//    loop 1
//      key 1 -> 1
//      key 4 -> 1
//      key 6 -> 1
//    loop 2
//      key 4-1=3 -> 1
//      key 6-1=5 -> 1
//    loop 3
//      key 6-4=2 -> 1
//    map=[1=1,2=1,3=1,4=1,5=1,6=1]
//  2. 첫번째 누적합[1 4 5 7]을 2중 for문으로 전체순회하면서 필요한 수를 map에서 찾는다. -> 답보고 배낌
//    loop 1
//      T(5) - 1 = 4  -> 1증가
//      T(5) - 4 = 1  -> 1증가
//      T(5) - 5 = 0  -> 없음 증가X
//      T(5) - 7 = -2 -> 없음 증가X
//    loop 2
//      T(5) - (4-1) = 2   -> 1증가
//      T(5) - (5-1) = 1   -> 1증가
//      T(5) - (7-1) = -1  -> 없음 증가X
//    loop 3
//      T(5) - (5-4) = 1   -> 1증가
//      T(5) - (7-4) = 2   -> 1증가
//    loop 4
//      T(5) - (7-5) = 3   -> 1증가
class S2143 {
    fun solution(input: List<String>): String {
        val target = input[0].toInt()
        val firstLen = input[1].toInt()
        val firstSt = StringTokenizer(input[2])
        val secondLen = input[3].toInt()
        val secondSt = StringTokenizer(input[4])
        val firstNums = IntArray(firstLen)
        val secondNums = IntArray(secondLen)

        firstNums[0] = firstSt.nextToken().toInt()
        for (i in 1 until firstNums.size) {
            firstNums[i] = firstSt.nextToken().toInt() + firstNums[i-1]
        }
        secondNums[0] = secondSt.nextToken().toInt()
        for (i in 1 until secondNums.size) {
            secondNums[i] = secondSt.nextToken().toInt() + secondNums[i-1]
        }
        val map = mutableMapOf<Int, Int>()
        for (secondStart in secondNums.indices) {
            for (secondEnd in secondStart until secondNums.size) {
                val secondSum = rangeSum(secondStart, secondEnd, secondNums)
                map.compute(secondSum) { _, v -> v?.plus(1) ?: 1 }
            }
        }


        var result = 0L
        for (start in firstNums.indices) {
            for (end in start until firstNums.size) {
                val firstSum = rangeSum(start, end, firstNums)
                val targetSum = target - firstSum
                result += map.getOrDefault(targetSum, 0)

            }
        }
        return result.toString()
    }

    private fun rangeSum(start: Int, end: Int, nums: IntArray): Int {
        val leftSum = if (start == 0) 0 else nums[start - 1]
        return nums[end] - leftSum
    }
}
