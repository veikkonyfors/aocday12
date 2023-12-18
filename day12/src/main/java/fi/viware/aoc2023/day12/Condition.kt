package fi.viware.aoc2023.day12

class Condition(val i: String) { // ".??..??...?##.

    fun getPossiblyBrokenIndices(): IntArray {
        return i.indices.filter { i[it] == '?' }.toIntArray()
    }

    fun getNumFixedBroken(): Int {
        return i.indices.filter { i[it] == '#' }.toIntArray().size
    }

    override fun toString(): String {
        return i
    }
}