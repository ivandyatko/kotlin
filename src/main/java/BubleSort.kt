import java.util.*

fun main(args: Array<String>) {
    val array = arrayOf(5, 7, 2, 8, 3, 0, 4, 6)

    for (i in array.size - 1 downTo 0) {
        for (j in 0..i - 1) {
            if (array[j] > array[j + 1]) {
                val temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
            }
        }
        println("i = $i; array = ${Arrays.toString(array)} \t")
    }
}