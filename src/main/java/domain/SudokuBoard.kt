package domain

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty
import org.optaplanner.core.api.domain.solution.PlanningScore
import org.optaplanner.core.api.domain.solution.PlanningSolution
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider
import org.optaplanner.core.api.score.buildin.simple.SimpleScore
import java.util.*

@PlanningSolution
data class SudokuBoard(
        @PlanningEntityCollectionProperty
        var cells: MutableList<Cell?> = ArrayList(),

        @PlanningScore
        var score: SimpleScore? = null,

        @ValueRangeProvider(id = "intRange")
        @ProblemFactCollectionProperty
        val range: List<Int> = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9),
) {

    fun printBoard() {
        for (i in 0..8) {
            var row = ""
            for (j in 0..8) {
                val currentCell = cells.stream().filter { cell: Cell? -> i == cell!!.column && j == cell.row }.findAny().orElse(null)
                row += currentCell!!.value.toString() + " "
                if ((j + 1) % 3 == 0) {
                    row += "| "
                }
            }
            println(row)
            if ((i + 1) % 3 == 0) {
                println("- - -   - - -   - - -")
            }
        }
    }

    fun fill(value: Int) {
        for (i in 0..8) {
            for (j in 0..8) {
                cells.add(Cell(j, i, value))
            }
        }
    }
}