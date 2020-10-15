package domain

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty
import org.optaplanner.core.api.domain.solution.PlanningScore
import org.optaplanner.core.api.domain.solution.PlanningSolution
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider
import org.optaplanner.core.api.score.buildin.simple.SimpleScore
import java.util.*

const val SUDOKU_DIMENSIONS = 9

@PlanningSolution
data class SudokuBoard(
        @PlanningEntityCollectionProperty
        var cells: MutableList<Cell?> = fillCells(),

        @PlanningScore
        var score: SimpleScore? = null,

        @ValueRangeProvider(id = "intRange")
        @ProblemFactCollectionProperty
        val range: List<Int> = listOf(1..SUDOKU_DIMENSIONS).flatten(),
) {

    override fun toString(): String {
        var str = "\t " + " - - -  ".repeat(SUDOKU_DIMENSIONS / 3) + "\n "

        for (i in 0 until SUDOKU_DIMENSIONS) {
            var row = "\t| "
            for (j in 0 until SUDOKU_DIMENSIONS) {
                val currentCell = cells.stream().filter { cell: Cell? -> i == cell!!.column && j == cell.row }.findAny().orElse(null)
                row += currentCell!!.value.toString() + " "
                if ((j + 1) % 3 == 0) {
                    row += "| "
                }
            }
            str += row + "\n"
            if ((i + 1) % 3 == 0) {
                str += "\t " + " - - -  ".repeat(SUDOKU_DIMENSIONS / 3) + "\n "
            }
        }
        return str
    }
}

fun fillCells(): MutableList<Cell?> {
    var cells: MutableList<Cell?> = ArrayList()

    for (i in 0 until SUDOKU_DIMENSIONS) {
        for (j in 0 until SUDOKU_DIMENSIONS) {

            cells.add(Cell(j, i, 0))
        }
    }
    return cells
}
