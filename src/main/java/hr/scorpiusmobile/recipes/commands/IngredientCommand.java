package hr.scorpiusmobile.recipes.commands;

import hr.scorpiusmobile.recipes.domain.Recipe;
import hr.scorpiusmobile.recipes.domain.UnitOfMeasure;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class IngredientCommand {

    private Long id;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasure uom;
    private Recipe recipe;
}
