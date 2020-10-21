package domain

import org.optaplanner.core.api.domain.entity.PlanningEntity
import org.optaplanner.core.api.domain.variable.PlanningVariable

@PlanningEntity
data class Cell(
        var column: Int = 0,
        var row: Int = 0,

        @PlanningVariable(valueRangeProviderRefs = ["intRange"])
        var value: Int? = null
) {
    override fun hashCode(): Int {
        return "$row$column".hashCode()
    }
}