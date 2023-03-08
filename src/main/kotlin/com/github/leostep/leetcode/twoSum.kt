package com.github.leostep.leetcode

fun main() {
    println(twoSum(intArrayOf(3, 2, 4), 6).contentToString())
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()
    nums.forEachIndexed { i, v ->
        val otherValue = target - v
        if (map.containsKey(otherValue))
            return intArrayOf(map.getValue(otherValue), i)
        else map[v] = i
    }
    return intArrayOf(-1, -1)
}
