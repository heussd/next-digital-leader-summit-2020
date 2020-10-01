import domain.SudokuBoard;
import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;

import java.util.List;
import java.util.stream.Collectors;

public class ScoreCalculator implements EasyScoreCalculator<SudokuBoard> {
    @Override
    public Score calculateScore(SudokuBoard sudokuBoard) {
        int hardScore = 0;
        int softScore = 0;


        for (int i = 1; i < 10; i++) {
            int finalI = i;
            // Score rows

            List<Integer> uniquesInRow = sudokuBoard.getCells().stream()
                    .filter(cell -> cell.getIndex_x() == finalI)
                    .map(cell -> cell.getValue())
                    .distinct()
                    .collect(Collectors.toList());
            hardScore -= Math.pow(9 - uniquesInRow.size(),2);

            // Score Columns
            List<Integer> uniquesInColumn = sudokuBoard.getCells().stream()
                    .filter(cell -> cell.getIndex_y() == finalI)
                    .map(cell -> cell.getValue())
                    .distinct()
                    .collect(Collectors.toList());
            hardScore -= Math.pow(9 - uniquesInColumn.size(),2);
        }

        // Score Regions
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int finalJ = j;
                int finalI = i;
                List<Integer> uniqueInRegion = sudokuBoard.getCells().stream()
                        .filter(cell -> cell.getIndex_x() > (finalI * 3) && cell.getIndex_x() <= (finalI*3) + 3 && cell.getIndex_y() > (finalJ * 3) && cell.getIndex_y() <= (finalJ*3) + 3)
                        .map(cell -> cell.getValue())
                        .distinct()
                        .collect(Collectors.toList());
                hardScore -= Math.pow(9 - uniqueInRegion.size(),2);
            }
        }

        return HardSoftScore.of(hardScore, softScore);

    }
}
