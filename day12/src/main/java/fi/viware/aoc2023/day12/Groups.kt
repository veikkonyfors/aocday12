package fi.viware.aoc2023.day12

class Groups(val input: String) {

    //"1,1,3"

    fun getNumBroken(): Int{
        val l = input.split(',').toTypedArray().map { it.toInt() }.sum()
        return l
    }

    fun toRegex(): Regex{
        val l = input.split(',').toTypedArray().map { it.toInt() }
        var r = "\\.*"
        l.forEach {
            for (i in 0 until it) r += '#'
            if ( l.last() != it )r += "\\.+"
        }
        r += "\\.*"
        return r.toRegex()
    }

    override fun toString(): String {
        return input
    }
}