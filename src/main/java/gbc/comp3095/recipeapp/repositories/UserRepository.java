package gbc.comp3095.recipeapp.repositories;

import gbc.comp3095.recipeapp.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User>  findUserByUserName(String username);
}
