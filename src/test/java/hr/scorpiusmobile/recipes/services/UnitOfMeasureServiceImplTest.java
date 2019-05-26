package hr.scorpiusmobile.recipes.services;

import hr.scorpiusmobile.recipes.commands.UnitOfMeasureCommand;
import hr.scorpiusmobile.recipes.converters.UnitOfMeasureToUnitOfMeasureCommand;
import hr.scorpiusmobile.recipes.domain.UnitOfMeasure;
import hr.scorpiusmobile.recipes.repositories.UnitOfMeasureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


class UnitOfMeasureServiceImplTest {

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();

    UnitOfMeasureService unitOfMeasureService;

    @BeforeEach
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        unitOfMeasureService = new UnitOfMeasureServiceImpl(unitOfMeasureRepository, unitOfMeasureToUnitOfMeasureCommand);
    }

    @Test
    void listAllUoms() {
        Set<UnitOfMeasure> unitOfMeasures = new HashSet<>();
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setId(1L);
        uom1.setDescription("oum 1 description");
        unitOfMeasures.add(uom1);
        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setId(2L);
        uom2.setDescription("uom2 description");
        unitOfMeasures.add(uom2);

        when(unitOfMeasureRepository.findAll()).thenReturn(unitOfMeasures);

        Set<UnitOfMeasureCommand> commands = unitOfMeasureService.listAllUoms();
        assertEquals(commands.size(), 2);
        verify(unitOfMeasureRepository, times(1)).findAll();

    }


}