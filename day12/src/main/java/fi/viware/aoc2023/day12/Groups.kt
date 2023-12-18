package fi.viware.aoc2023.day12

class Groups(val input: String) {

    fun getNumBroken(): Int{
        val l = input.split(',').toTypedArray().map { it.toInt() }.sum()
        return l
    }

    override fun toString(): String {
        return input
    }
}