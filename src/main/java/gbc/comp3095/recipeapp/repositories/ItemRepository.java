package gbc.comp3095.recipeapp.repositories;

import gbc.comp3095.recipeapp.models.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
