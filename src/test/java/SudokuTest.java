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
        for(int i = 1; i < 10; i++){
            for(int j = 1; j < 10; j++){
                int value = 1;
//                if (i == 1 && j == 1){
//                    value = 5;
//                } else if (i == 3 && j == 1){
//                    value = 7;
//                } else if (i == 4 && j == 1){
//                    value = 4;
//                }else if (i == 6 && j == 1){
//                    value = 1;
//                }else if (i == 9 && j == 1){
//                    value = 2;
//                }else if (i == 7 && j == 2){
//                    value = 3;
//                }else if (i == 3 && j == 3){
//                    value = 2;
//                }else if (i == 5 && j == 3){
//                    value = 9;
//                }else if (i == 8 && j == 3){
//                    value = 6;
//                }else if (i == 1 && j == 4){
//                    value = 8;
//                }else if (i == 7 && j == 4){
//                    value = 7;
//                }else if (i == 8 && j == 4) {
//                    value = 4;
//                }

                unsolvedSudokuBoard.cells.add(new Cell(j,i,value));
            }
        }

        SudokuBoard solvedSudokuBoard = solver.solve(unsolvedSudokuBoard);

        solvedSudokuBoard.printBoard();
        Assert.assertEquals(0, solvedSudokuBoard.getScore().getHardScore());
    }

}
