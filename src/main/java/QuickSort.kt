import java.util.*

fun main(args: Array<String>) {

    val random = Array(15, { next() })

    println(Arrays.toString(random))

    quickSort(random)

}

fun quickSort(arr: Array<Int>) {
    var left = 0
    var right = arr.size - 2
    val pivot = arr[arr.size / 2]

    do {
        while (arr[left] < pivot) left++
        while (arr[right] > pivot) right--

        if (arr[left] <= arr[right]) {
            val temp = arr[left]
            arr[left] = arr[right]
            arr[right] = temp
        }
        right--
        left++

    } while (left < right)

    if (left > 0)
        quickSort(Arrays.copyOfRange(arr, 0, pivot))

    if (arr.size > left)
        quickSort(Arrays.copyOfRange(arr, pivot + 1, arr.size - 1))
}