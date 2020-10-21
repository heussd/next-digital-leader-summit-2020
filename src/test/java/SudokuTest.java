import domain.SudokuBoard;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SudokuTest {

    @Test
    public void score() {
        SudokuBoard unsolvedSudokuBoard = new SudokuBoard();
        SudokuBoard solvedSudokuBoard = OptaPlannerKt.solveAndPrint(unsolvedSudokuBoard);
        Assert.assertEquals(0, solvedSudokuBoard.getScore().getScore());
    }

    @Test
    public void task0() {
        System.out.println("Fight Bugs                      |     |");
        System.out.println("                                \\_V_//");
        System.out.println("                                \\/=|=\\/");
        System.out.println("                                 [=v=]");
        System.out.println("                               __\\___/_____");
        System.out.println("                              /..[  _____  ]");
        System.out.println("                             /_  [ [  M /] ]");
        System.out.println("                            /../.[ [ M /@] ]");
        System.out.println("                           <-->[_[ [M /@/] ]");
        System.out.println("                          /../ [.[ [ /@/ ] ]");
        System.out.println("     _________________]\\ /__/  [_[ [/@/ C] ]");
        System.out.println("    <_________________>>0---]  [=\\ \\@/ C / /");
        System.out.println("       ___      ___   ]/000o   /__\\ \\ C / /");
        System.out.println("          \\    /              /....\\ \\_/ /");
        System.out.println("       ....\\||/....           [___/=\\___/");
        System.out.println("      .    .  .    .          [...] [...]");
        System.out.println("     .      ..      .         [___/ \\___]");
        System.out.println("     .    0 .. 0    .         <---> <--->");
        System.out.println("/\\/\\.    .  .    ./\\/\\      [..]   [..]");
        System.out.println(" / / / .../|  |\\... \\ \\ \\    _[__]   [__]_");
        System.out.println("/ / /       \\/       \\ \\ \\  [____>   <____]");
    }


    @Test
    public void task1() {
        SudokuBoard unsolvedSudokuBoard = new SudokuBoard();
        SudokuBoard solvedSudokuBoard = OptaPlannerKt.solveAndPrint(unsolvedSudokuBoard);

        solvedSudokuBoard.getCells().stream().forEach(cell -> {
                    Assert.assertEquals(Integer.valueOf(8), cell.getValue());
                }
        );
    }

    @Test
    public void task2() {
        SudokuBoard unsolvedSudokuBoard = new SudokuBoard();
        SudokuBoard solvedSudokuBoard = OptaPlannerKt.solveAndPrint(unsolvedSudokuBoard);

        for (int i = 0; i < 9; i++) {
            int finalI = i;
            long rowCount = solvedSudokuBoard.getCells().stream().filter(cell -> cell.getRow() == finalI)
                    .map(cell -> cell.getValue())
                    .distinct().count();
            long colCount = solvedSudokuBoard.getCells().stream().filter(cell -> cell.getColumn() == finalI)
                    .map(cell -> cell.getValue())
                    .distinct().count();

            Assert.assertEquals("Rows are not filled properly", 9, rowCount);
            Assert.assertEquals("Columns are not filled properly", 9, colCount);
        }
    }

    @Test
    public void task3() {
        SudokuBoard unsolvedSudokuBoard = new SudokuBoard();
        SudokuBoard solvedSudokuBoard = OptaPlannerKt.solveAndPrint(unsolvedSudokuBoard);

        for (int column = 0; column < 9; column++)
            for (int row = 0; row < 9; row++) {
                String region = (row / 3) + "" + ((column / 3) + "");

                long regionCount = solvedSudokuBoard.getCells().stream().filter(cell -> region.equals((cell.getRow() / 3) + "" + ((cell.getColumn() / 3) + "")))
                        .map(cell -> cell.getValue())
                        .distinct().count();

                Assert.assertEquals("Regions are not filled properly", 9, regionCount);
            }
    }
}
