package hr.scorpiusmobile.recipes.services;

import hr.scorpiusmobile.recipes.domain.UnitOfMeasure;
import hr.scorpiusmobile.recipes.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    UnitOfMeasureRepository unitOfMeasureRepository;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public Set<UnitOfMeasure> listAllUoms() {

        Set listOfUoms = new HashSet();
        unitOfMeasureRepository.findAll().forEach(listOfUoms::add);
        return listOfUoms;
    }
}
