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

    fun getNumPossibilitiesToAddBroken(): Int{

        val hashCount = condition.getNumFixedBroken()
        val totalSlots = condition.i.length
        val array = CharArray(totalSlots) { '.' }
        val candidateIndexesForBroken = condition.getPossiblyBrokenIndices()
        var conditionArray: CharArray

        var permutations: MutableList<CharArray> = mutableListOf()
        var conditionsList: MutableList<CharArray> = mutableListOf()


        generatePermutations(array, hashCount, 0, permutations)

        var s = ""
        var sc = ""
        permutations.forEach{
            s += String(it) + "\n"
            conditionArray = condition.i.toCharArray()
            it.forEachIndexed { index, c ->
                conditionArray[candidateIndexesForBroken[index]]=c
            }
            conditionsList.add(conditionArray)
            sc += String(conditionArray) + "\n"
        }
        println("${s} ${sc}")

        return sc.length
    }

    fun generatePermutations(array: CharArray, hashCount: Int, index: Int, permutations: MutableList<CharArray> ){
        if (index == array.size) {
            if (array.count { it == '#' } == hashCount) {
                //println(array.joinToString(""))
                permutations.add(array.copyOf())
            }
            return
        }

        array[index] = '#'
        generatePermutations(array, hashCount, index + 1, permutations)

        array[index] = '.'
        generatePermutations(array, hashCount, index + 1, permutations)

    }

    override fun toString(): String {
        return "$condition $groups"
    }



}