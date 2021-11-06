package gbc.comp3095.recipeapp.services.Implementations;

import gbc.comp3095.recipeapp.models.BaseEntity;
import gbc.comp3095.recipeapp.repositories.AbstractRepository;
import gbc.comp3095.recipeapp.services.Interfaces.CrudService;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class AbstractDataAccessService<T extends BaseEntity, ID extends Long> implements CrudService<T, ID>{



    protected AbstractRepository abstractRepository;

    protected CrudRepository<T, ID> getRepository() {
        return null;
    }

    public AbstractDataAccessService(AbstractRepository abstractRepository) {
        this.abstractRepository = abstractRepository;
    }

    public Optional<T> findById(ID id) {
            return abstractRepository.findById(id);
    }

    @Override
    public Optional<T> find(T object) {
        return Optional.empty();
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
        public void delete(T object) {
            abstractRepository.delete(object);
        }
        public void deleteById(ID id){
            abstractRepository.deleteById(id);
        }







}
