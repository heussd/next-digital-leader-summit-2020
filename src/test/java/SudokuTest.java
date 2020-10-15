import domain.SudokuBoard;
import org.junit.Assert;
import org.junit.Test;

public class SudokuTest {
    @Test
    public void firstTest(){
        SudokuBoard unsolvedSudokuBoard = new SudokuBoard();
        SudokuBoard solvedSudokuBoard = OptaPlannerKt.solveAndPrint(unsolvedSudokuBoard);

        Assert.assertEquals(0, solvedSudokuBoard.getScore().getScore());
    }

}
