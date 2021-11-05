package gbc.comp3095.recipeapp.repositories;

import gbc.comp3095.recipeapp.models.BaseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public  interface AbstractRepository <T extends BaseEntity> extends CrudRepository<T , Long> {

}
