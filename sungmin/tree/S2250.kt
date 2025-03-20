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
            bw.write(S2250().solution(br.lines().collect(Collectors.toList())))
            br.close()
            bw.flush()
        }
    }
}
// TODO 틀림 아직못품
// TODO 최대길이 찾기
//  1. 한줄             > 1
//      1 -> 1
//     2
//    3
//  2. 양쪽채워진게 제일길다 > 노드수
//    한번만 양사이드 모두 안쪽으로 들어가면 이렇게 됨
//        1
//       2 3
//      4  5 6 -> 8
//       7  8
//  3. 기울어졌다         > 노드수-1
//         1
//      2       3   ->> 4 | 5 | 6 |
//     4     5      ->> 4 |   |   | 기울어짐 시작지점
//    6       7     ->>   | 6 |   |
//   8         9    ->>   |   | 8 | 최대
//  -------------------------------------------
//         1
//      2     3   ->> 4 | 5 |
//    4      5    ->> 4 | 6 | 최대 / 기울어짐 시작지점
//     6    7     ->>   | 4 | 양쪽이 안으로 들어감 - 뭔짓을해도 이후에는 위를 이길 수 없음
//  -------------------------------------------
//         1
//      2        3   ->> 4 | 5 | 6 |
//  4        5       ->> 4 |   |   | 기울어짐 시작지점
//     6      7      ->>   | 5 |   |
//   8         9     ->>   |   | 7 | 최대 - 뒤쪽에 계속 커질 가능성이 있음
//  -------------------------------------------
//         1
//      2        3   ->> 4 | 5 | 6 |
//  4        5       ->> 4 |   |   | 기울어짐 시작지점
//     6      7      ->>   | 5 |   |
//   8         9     ->>   |   | 7 | 최대 - 뒤쪽에 계속 커질 가능성이 있음
//        1        1
//       2  3      4
//  4      8       7
//    5            1
//   6 7           3
data class Node2(val left: Int, val right: Int)
class S2250 {
    fun solution(input: List<String>): String {
        val len = input.first().toInt()
        val all = (1..len).toMutableSet()
        val nodes = Array(len + 1) { i ->
            if (i == 0) Node(-1, -1, -1, -1, null, null)
            else {
                val st = StringTokenizer(input[i])
                st.nextToken()
                val left = st.nextToken().toInt()
                val right = st.nextToken().toInt()
                all.remove(left)
                all.remove(right)
                Node(i, left, right, null, null, null)
            }
        }
        val root = all.first()
        val rootNode = nodes[root]
        var queue = LinkedList<Node>()
        queue.add(rootNode)
        var depth = 1
        var leftestNode = rootNode
        while (queue.isNotEmpty()) {
            val nextQueue = LinkedList<Node>()
            while (queue.isNotEmpty()) {
                val node = queue.poll()
                node.depth = depth
                if (node.left != -1) {
                    val leftNode = nodes[node.left]
                    val preNode = node.pre
                    if (preNode != null) {
                        preNode.next = leftNode
                        leftNode.pre = preNode
                    }
                    leftNode.next = node
                    node.pre = leftNode
                    nextQueue.add(leftNode)
                }
                if (node.right != -1) {
                    val rightNode = nodes[node.right]
                    val nextNode = node.next
                    node.next = rightNode
                    rightNode.pre = node
                    if (nextNode != null) {
                        rightNode.next = nextNode
                        nextNode.pre = rightNode
                    }
                    nextQueue.add(rightNode)
                }
            }
            if (nextQueue.isNotEmpty() && nextQueue.first().next == leftestNode) {
                leftestNode = nextQueue.first()
            }
            depth++
            queue = nextQueue
        }

        var curNode: Node? = leftestNode
        var maxSize = 1
        var maxDepth = 1
        var index = 0
        val startIndex = IntArray(depth+1) { -1 }
        while(curNode != null) {
            val start = startIndex[curNode.depth!!]
            if (start == -1) {
                startIndex[curNode.depth!!] = index
            } else {
                val size = index - start + 1
                if (size > maxSize || (size == maxSize && maxDepth > curNode.depth!!)) {
                    maxSize = size
                    maxDepth = curNode.depth!!
                }
            }

            curNode = curNode.next
            index++
        }

        return "$maxDepth $maxSize"
    }
    data class Node(
        val id: Int,
        val left: Int,
        val right: Int,
        var depth: Int?,
        var pre: Node?,
        var next: Node?,
    )
}
