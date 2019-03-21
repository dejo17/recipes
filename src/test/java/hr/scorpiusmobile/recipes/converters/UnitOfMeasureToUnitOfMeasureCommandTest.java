package hr.scorpiusmobile.recipes.converters;

import hr.scorpiusmobile.recipes.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitOfMeasureToUnitOfMeasureCommandTest {

    UnitOfMeasureToUnitOfMeasureCommand converter;
    @BeforeEach
    void setUp() {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }
    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }
    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }
    @Test
    void convert() {
    }
}