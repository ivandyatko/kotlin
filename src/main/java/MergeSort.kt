import java.util.*

fun main(args: Array<String>) {
    val arr = arrayOf(3, 8, 33, 89, 4, 21, 6, 0, 5)
    println(Arrays.toString(arr))
    sort(arr)

    println(Arrays.toString(arr))

}

fun merge(arr: Array<Int>, lb: Int, rb: Int, mid: Int) {
    var bpos = 0
    val buf: Array<Int> = Array<Int>(rb - lb + 1, { 0 })
    var lpos = lb
    var rpos = mid + 1

    while (lpos <= mid && rpos <= rb) {
        if (arr[lpos] < arr[rpos])
            buf[bpos++] = arr[lpos++]
        else
            buf[bpos++] = arr[rpos++]
    }

    while (lpos <= mid)
        buf[bpos++] = arr[lpos++]

    while (rpos <= rb)
        buf[bpos++] = arr[rpos++]

    for (pos3 in 0..rb - lb)
        arr[lb + pos3] = buf[pos3]
}


fun mergeSort(array: Array<Int>, lb: Int, rb: Int) {
    val mid: Int;

    if (lb < rb) {
        mid = (lb + rb) / 2
        mergeSort(array, lb, mid)
        mergeSort(array, mid + 1, rb)
        merge(array, lb, rb, mid)
    }
}

fun sort(array: Array<Int>) {
    mergeSort(array, 0, array.size - 1)
}