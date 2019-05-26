package hr.scorpiusmobile.recipes.services;

import hr.scorpiusmobile.recipes.commands.UnitOfMeasureCommand;
import hr.scorpiusmobile.recipes.domain.UnitOfMeasure;

import java.util.Set;

public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> listAllUoms();
}
