package gbc.comp3095.recipeapp.repositories;

import gbc.comp3095.recipeapp.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
