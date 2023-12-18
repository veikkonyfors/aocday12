package fi.viware.aoc2023.day12

class ConditionRecord(val input: String) {

    var condition: Condition
    var groups: Groups

    // ".??..??...?##. 1,1,3"

    init {
        val l = input.split(' ')
        condition = Condition(l[0])
        groups = Groups(l[1])
    }

    fun getNumBrokenToAddIntoCondition(): Int{
        return groups.getNumBroken() - condition.getNumFixedBroken()
    }

    fun getNumVariationsToAddBroken(): Int{
        val slotsToLocateBroken = condition.getPossiblyBrokenIndices()
        val numBrokenToAdd = getNumBrokenToAddIntoCondition()
        val n = permutations(condition.getPossiblyBrokenIndices().size, getNumBrokenToAddIntoCondition())
        return n
    }

    fun factorial(n: Int): Int {
        var result = 1
        for (i in 2..n) {
            result *= i
        }
        return result
    }

    fun permutations(n: Int, k: Int): Int {
        require(n >= k) { "n must be greater than or equal to k" }
        return factorial(n) / factorial(n - k)
    }

    override fun toString(): String {
        return "$condition $groups"
    }



}