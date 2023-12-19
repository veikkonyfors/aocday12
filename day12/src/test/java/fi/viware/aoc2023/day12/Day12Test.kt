package fi.viware.aoc2023.day12

import org.junit.Assert.*
import org.junit.Test


class Day12Test(){

    val day12 = Day12(".??..??...?##. 1,1,3")

    @Test
    fun day12(){

        println("$day12")
        assertEquals(".??..??...?##. 1,1,3", day12.toString())

        var n = day12.conditionRecord.groups.getNumBroken()
        println("$n")
        assertEquals(5, n)

        val possiblyBrokenIndices = day12.conditionRecord.condition.getPossiblyBrokenIndices()
        val s = possiblyBrokenIndices.joinToString(separator = ", ") { it.toString() }
        println("$s")
        assertEquals("1, 2, 5, 6, 10", s)

        n = day12.conditionRecord.condition.getNumFixedBroken()
        println("$n")
        assertEquals(2, n)

        n = day12.conditionRecord.getNumBrokenToAddIntoCondition()
        println("$n")
        assertEquals(3, n)

        n = day12.conditionRecord.getNumPossibilitiesToAddBroken()
        println("$n")
        assertEquals(4, n)


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

    @Test
    fun main() {
        val hashCount = 3
        val totalSlots = 5
        val array = CharArray(totalSlots) { '.' }
        val candidateIndexesForBroken = intArrayOf(1, 2, 5, 6, 10)
        var conditionArray = ".??..??...?##.".toCharArray()

        var permutations: MutableList<CharArray> = mutableListOf()
        var conditionsList: MutableList<CharArray> = mutableListOf()


        generatePermutations(array, hashCount, 0, permutations)

        var s = ""
        var sc = ""
        permutations.forEach{
            s += String(it) + "\n"
            conditionArray = ".??..??...?##.".toCharArray()
            it.forEachIndexed { index, c ->
                conditionArray[candidateIndexesForBroken[index]]=c
            }
            conditionsList.add(conditionArray)
            sc += String(conditionArray) + "\n"
        }
        println("${s} ${sc}")
    }
}

/*

###..
##.#.
##..#
#.#.#
#..##
.#.##
..###

 */