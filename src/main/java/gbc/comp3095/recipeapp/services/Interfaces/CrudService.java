package gbc.comp3095.recipeapp.services.Interfaces;

import gbc.comp3095.recipeapp.models.BaseEntity;
import gbc.comp3095.recipeapp.models.User;

import java.util.Optional;

public interface CrudService <T extends BaseEntity, ID>    {

        Optional<T> findById(ID id);
        Optional<T> find(T object);
        T save(T object);
        Iterable<T> findAll();
        void delete(T object);
        void deleteById(ID id);

}




