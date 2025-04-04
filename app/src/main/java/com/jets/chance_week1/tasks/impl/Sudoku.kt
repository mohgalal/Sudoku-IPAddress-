package com.jets.chance_week1.tasks.impl

fun main() {
    val list = listOf(
        listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
        listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
        listOf('5', '9', '8', '-', '-', '-', '-', '6', '-'),
        listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
        listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
        listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
        listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
        listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
        listOf('-', '-', '-', '-', '8', '-', '-', '7', '9'),
    )
    val res = isSudokuGameValid(list)
    println(res)
}

fun isSudokuGameValid(
    gameBoard: List<List<Char>>
): Boolean {
    if (gameBoard.isEmpty())
        return true
    else if (gameBoard.size != 9 || gameBoard.any { it.size != 9 }) {
        return false
    }

    return isCharacterValid(gameBoard) &&
            isRowValid(gameBoard) &&
            isColumnValid(gameBoard) &&
            isSubgridValid(gameBoard)
}

fun isRowValid(gameBoard: List<List<Char>>): Boolean {
    gameBoard.forEach { listOfRows ->
        val seen = mutableSetOf<Char>()
        listOfRows.forEach { currentItem ->
            if (currentItem != '-') {
                if (currentItem in seen)
                    return false
                seen.add(currentItem)
            }
        }
    }
    return true
}

fun isColumnValid(gameBoard: List<List<Char>>): Boolean {
    for (column in 0..8) {
        val seen = mutableSetOf<Char>()
        gameBoard.forEach { listOfRows ->
            val currentItem = listOfRows[column]
            if (currentItem != '-')
                if (currentItem in seen)
                    return false
            seen.add(currentItem)
        }
    }
    return true
}

fun isSubgridValid(gameBoard: List<List<Char>>): Boolean {

    for (rowSubgrid in 0..2) {
        for (columnSubgrid in 0..2) {
            val seen = mutableSetOf<Char>()
            for (row in 0..2) {
                for (column in 0..2) {
                    val currentItem = gameBoard[rowSubgrid * 3 + row][columnSubgrid * 3 + column]
                    if (currentItem != '-')
                        if (currentItem in seen)
                            return false
                    seen.add(currentItem)
                }
            }
        }
    }

    return true
}

fun isCharacterValid(gameBoard: List<List<Char>>): Boolean {
    val validationChar = setOf('1', '2', '3', '4', '5', '6', '7', '8', '9', '-')
    return gameBoard.all { listOfRows ->
        listOfRows.all { currentItem ->
            currentItem in validationChar
        }
    }
}










// region sudoku v1
/*
fun isSudokuGameValid(
    gameBoard: List<List<Char>>
): Boolean {
    var isValid = true

    if (gameBoard.isEmpty())
        isValid = true
    else if (gameBoard.size != 9)
        isValid = false
    else if (gameBoard[0].size != 9)
        isValid = false
    else {
        isValid = isRowValid(gameBoard)
    }

    return isValid
}

private fun isRowValid(gameBoard: List<List<Char>>): Boolean {
    val seen = mutableListOf<Char>()
    gameBoard.forEach { listOfRows ->
        listOfRows.forEach { currentChar ->
            print("  $currentChar  ")
            if (currentChar == '-')
            else if (currentChar in seen) {
                return false
            } else {
                seen.add(currentChar)
            }
        }
        println()
        seen.clear()
    }
    return true
}

*/
