package com.github.leostep.leetcode

fun main() {
    println(isIsomorphic("abcdefghijklmnopqrstuvwxyz", "zbcdefghijklmnopqrstuvwxya"))
}

fun isIsomorphic(s: String, t: String): Boolean {
    return s == t || map(s) == map(t)
}

private fun map(s: String): String {
    val map = HashMap<Char, String>()
    val res = StringBuilder()
    var num = 0
    for (curr in s) {
        if (!map.containsKey(curr)) {
            map[curr] = "|" + num++
        }
        res.append(map[curr])
    }
    return res.toString()
}
