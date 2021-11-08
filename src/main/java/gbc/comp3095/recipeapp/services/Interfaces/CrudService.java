/*********************************************************************************
 * Project: < COMP3095_Assignment1 >
 * Assignment: < assignment 1 >
 * Author(s): < Saad Khan >
 * Student Number: < 101157307 >
 * Date: 07-11-2021
 * Description: CrudService interface implemented by all services defines methods for CRUD operations.
 *********************************************************************************/
package gbc.comp3095.recipeapp.services.Interfaces;

import gbc.comp3095.recipeapp.models.BaseEntity;

import java.util.Optional;

public interface CrudService <T extends BaseEntity, ID>    {

        Optional<T> findById(ID id);
        Optional<T> find(T object);
        T save(T object);
        Iterable<T> findAll();
        void delete(T object);
        void deleteById(ID id);

}




