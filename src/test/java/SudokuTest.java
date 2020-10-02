import domain.Cell;
import domain.SudokuBoard;
import org.junit.Assert;
import org.junit.Test;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

public class SudokuTest {
    @Test
    public void firstTest(){
        SolverFactory<SudokuBoard> solverFactory = SolverFactory
                .createFromXmlResource("solver.xml");
        Solver<SudokuBoard> solver = solverFactory.buildSolver();

        SudokuBoard unsolvedSudokuBoard = new SudokuBoard();
        unsolvedSudokuBoard.fill(1);

        SudokuBoard solvedSudokuBoard = solver.solve(unsolvedSudokuBoard);

        solvedSudokuBoard.printBoard();
        Assert.assertEquals(0, solvedSudokuBoard.getScore().getScore());
    }

}
