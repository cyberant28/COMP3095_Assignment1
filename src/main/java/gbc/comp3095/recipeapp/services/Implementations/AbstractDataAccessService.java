package gbc.comp3095.recipeapp.services.Implementations;

import gbc.comp3095.recipeapp.models.BaseEntity;
import gbc.comp3095.recipeapp.repositories.AbstractRepository;

import java.util.Optional;

public class AbstractDataAccessService<T extends BaseEntity, ID extends Long> {



    protected AbstractRepository abstractRepository;

    public AbstractDataAccessService(AbstractRepository abstractRepository) {
        this.abstractRepository = abstractRepository;
    }

    protected Optional<T> findById(ID id) {
            return abstractRepository.findById(id);
    }



    public T save(T object) {
            if(object != null){
                abstractRepository.save(object);
            }
            else {
                throw new RuntimeException("Object cannot be null");
            }
            return object;
        }

        public Iterable <T> findAll() {
            return abstractRepository.findAll();
        }
        void delete(T object) {
            abstractRepository.delete(object);
        }
        void deleteById(ID id){
            abstractRepository.deleteById(id);
        }







}
