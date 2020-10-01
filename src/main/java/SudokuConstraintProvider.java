import domain.Cell;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;

import java.util.ArrayList;

public class SudokuConstraintProvider implements ConstraintProvider {

    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {

        return new Constraint[0];
    }

//    public Constraint rowConstraint(ConstraintFactory constraintFactory){
//        return constraintFactory.from(Cell.class)
//                .groupBy(cell -> cell.getIndex_x())
//                .
//
//                .join(Workload::class.java,
//                Joiners.equal(Workload::bundle),
//                Joiners.lessThan(Workload::cloudType))
//                .penalize("Don't assign Ann", HardSoftScore.ONE_SOFT);
//    }
}
