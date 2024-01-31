fun getFactors(nums: List<Int>): List<Int> =
    nums.flatMap { num -> (1..num).filter { num % it == 0 } }.distinct()

fun main() {
    println(getFactors(listOf(2, 5, 7, 8, 12, 18, 15)))
    println(getFactors(listOf(2, 6)))
}
