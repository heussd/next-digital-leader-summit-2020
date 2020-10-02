package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {


    @Test
    public void testRegion() {
        var cell1 = new Cell(0, 1, 1);
        assertEquals("00", cell1.getRegion());

        var cell2 = new Cell(8, 8, 1);
        assertEquals("22", cell2.getRegion());
    }

}