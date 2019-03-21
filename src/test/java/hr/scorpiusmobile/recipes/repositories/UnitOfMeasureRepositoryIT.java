package hr.scorpiusmobile.recipes.repositories;

import hr.scorpiusmobile.recipes.domain.UnitOfMeasure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    public void setUp() throws Exception {

    }
    @Test
    public void findByDescription() throws Exception{
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("teaspoon");
        assertEquals("teaspoon", uomOptional.get().getDescription());
    }
    @Test
    public void findByDescriptionCup() throws Exception{
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("cup");
        assertEquals("cup", uomOptional.get().getDescription());
    }

}