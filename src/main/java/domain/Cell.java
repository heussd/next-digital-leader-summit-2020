package domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Cell {
    public Integer column;
    public Integer row;
    public Integer value;

    public Cell(Integer column, Integer row, Integer value) {
        this.column = column;
        this.row = row;
        this.value = value;
    }

    public Cell() {
    }

    public Integer getColumn(){
        return column;
    }

    public Integer getRow(){
        return row;
    }

    @PlanningVariable(valueRangeProviderRefs = {"intRange"})
    public Integer getValue(){
        return value;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getRegion() {
        return (row /3 + "") + (column / 3 + "");
    }

    @Override
    public String toString() {
        return "Cell{" +
                "  column=" + column +
                ", row=" + row +
                ", value=" + value +
                '}';
    }
}
