import java.util.*
import java.util.function.Supplier

fun printMatrix(matrix: Array<Array<Int>>) {
    for (item in matrix) {
        print("| \t")
        for (i in item) print("$i \t")
        println("|")
    }
}

fun main(args: Array<String>) {
    val rand: Random = Random()

    val size = 5

    val matrix = Array<Array<Int>>(size) { Array(size, { rand.nextInt(100) }) }

    printMatrix(matrix)

    for (i in 0..size - 1) {
        for (j in 0..size - 1) {
            if (i < j) {
                matrix[i][j] += matrix[j][i]
                matrix[j][i] = matrix[i][j] - matrix[j][i]
                matrix[i][j] -= matrix[j][i]
            }
        }
    }
    println()
    printMatrix(matrix)
}
