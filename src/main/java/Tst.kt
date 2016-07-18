import java.util.*

fun nanos(): Long {
    return System.nanoTime()
}

fun main(args: Array<String>) {
    val min = 1
    var dupl: Int = -1;

    val times = ArrayList<Long>()

    val rand: Random = Random()

    fun next(max: Int): Int {
        return rand.nextInt(max - min) + 1
    }

    for (maxVal in 1..10) {
        val max = maxVal * 100;

        val arr = Array(max + 1, { i -> i + 1 })
        arr[max] = max

        println()
        println(Arrays.toString(arr))

        val start = nanos()

        outer@ for (i in min..max) {
            val current = arr[i]
            for (j in i..arr.size) {
                if (current === arr[j]) {
                    dupl = arr[j]
                    break@outer
                }
            }
        }

        val end = nanos()

        println("First dupl value is $dupl")
        println("Array size = ${max + 1}, search time = ${end - start}")
        times.add(end - start)
    }

    print(times)
}