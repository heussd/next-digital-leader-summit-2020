import domain.SudokuBoard
import org.optaplanner.core.api.score.ScoreManager
import org.optaplanner.core.api.solver.SolverFactory

fun solveAndPrint(unsolvedSudokuBoard: SudokuBoard): SudokuBoard {
    val solverFactory = SolverFactory
            .createFromXmlResource<SudokuBoard>("solver.xml")
    val scoreManager = ScoreManager.create(solverFactory)

    val solver = solverFactory.buildSolver()

    val solvedSudokuBoard = solver.solve(unsolvedSudokuBoard)

    println("\n\n")
    println(solvedSudokuBoard)
    println(scoreManager.explainScore(solvedSudokuBoard))

    return solvedSudokuBoard
}