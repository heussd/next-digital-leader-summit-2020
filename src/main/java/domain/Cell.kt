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
    fun getRegion(): String {
        return (row / 3).toString() + "" + ((column / 3).toString() + "")
    }

    override fun hashCode(): Int {
        return getRegion().hashCode()
    }
}