package com.example.android.navigation

class FindThesis {
    fun minimumJumps(jetpack: IntArray): Int {
        val len = jetpack.size

        if(len < 2)
            return 0

        val jumps = IntArray(len)

        jumps[0] = 0
        for(k in 1 until len)
            jumps[k] = Integer.MAX_VALUE - 1

        for(j in 1 until len) {
            for(i in 0 until j) {
                if(i+jetpack[i] >= j) {
                    jumps[j] = Math.min(jumps[j], jumps[i] + 1)
                }
            }
        }

        return jumps[len-1]
    }

    fun main(args: Array<String>) {
        val jetpack = intArrayOf(2,3,1,1,3)
        val minJumps = minimumJumps(jetpack)
        println("Min Jumps Required: $minJumps")
    }
}