package domain;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.simple.SimpleScore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@PlanningSolution
public class SudokuBoard {

    public List<Cell> cells = new ArrayList<Cell>();

    public SimpleScore score;

    @PlanningEntityCollectionProperty
    public List<Cell> getCells(){
        return cells;
    }

    //@ValueRangeProvider(id = "intRange")
    /*public CountableValueRange<Integer> getIntRange() {
        return ValueRangeFactory.createIntValueRange(1, 10, 1);
    }*/

    @ProblemFactCollectionProperty
    @ValueRangeProvider(id = "intRange")
    public List<Integer> getRange() {
        return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @PlanningScore
    public SimpleScore getScore(){
        return score;
    }



    public void setScore(SimpleScore score) {
        this.score = score;
    }

    public List<Cell[]> getRows(){
        return null;
    }
    public List<Cell[]> getColumns(){
        return null;
    }

    public List<Cell[]> getRegions(){
        return null;
    }

    public void printBoard(){
        for(int i = 1; i < 10; i++){
            String row = "";
            for(int j = 1; j<10;j++){
                int finalI = i;
                int finalJ = j;
                Cell currentCell = cells.stream().filter(cell -> finalI == cell.getIndex_x() && finalJ == cell.getIndex_y()).findAny().orElse(null);
                row += currentCell.getValue().toString() + " ";
                if(j%3 == 0){
                    row+= "| ";
                }
            }
            System.out.println(row);
            if(i%3 == 0){
                System.out.println("- - -   - - -   - - -");
            }
        }
    }
}
