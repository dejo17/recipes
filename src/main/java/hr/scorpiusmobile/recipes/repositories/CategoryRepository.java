package hr.scorpiusmobile.recipes.repositories;

import hr.scorpiusmobile.recipes.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
