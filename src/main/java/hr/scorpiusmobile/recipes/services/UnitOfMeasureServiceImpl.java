package hr.scorpiusmobile.recipes.services;

import hr.scorpiusmobile.recipes.commands.UnitOfMeasureCommand;
import hr.scorpiusmobile.recipes.converters.UnitOfMeasureToUnitOfMeasureCommand;
import hr.scorpiusmobile.recipes.domain.UnitOfMeasure;
import hr.scorpiusmobile.recipes.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    UnitOfMeasureRepository unitOfMeasureRepository;
    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository,
                                    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {

        return StreamSupport.stream(unitOfMeasureRepository
                .findAll()
                .spliterator(),false)
                .map(unitOfMeasureToUnitOfMeasureCommand::convert)
                .collect(Collectors.toSet());
    }
}
