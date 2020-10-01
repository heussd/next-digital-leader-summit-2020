package domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Cell {
    public Integer index_x;
    public Integer index_y;
    public Integer value;

    public Cell(Integer index_x, Integer index_y, Integer value) {
        this.index_x = index_x;
        this.index_y = index_y;
        this.value = value;
    }

    public Cell() {
    }

    public Integer getIndex_x(){
        return index_x;
    }

    public Integer getIndex_y(){
        return index_y;
    }

    @PlanningVariable(valueRangeProviderRefs = {"intRange"})
    public Integer getValue(){
        return value;
    }

    public void setIndex_x(Integer index_x) {
        this.index_x = index_x;
    }

    public void setIndex_y(Integer index_y) {
        this.index_y = index_y;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "index_x=" + index_x +
                ", index_y=" + index_y +
                ", value=" + value +
                '}';
    }
}
