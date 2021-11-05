package gbc.comp3095.recipeapp.services.Implementations.user;

import gbc.comp3095.recipeapp.models.User;
import gbc.comp3095.recipeapp.repositories.AbstractRepository;
import gbc.comp3095.recipeapp.services.Implementations.AbstractDataAccessService;
import gbc.comp3095.recipeapp.services.Interfaces.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends AbstractDataAccessService<User, Long> implements UserService {


    @Autowired
    public UserServiceImpl(AbstractRepository<User> userRepository) {
        super(userRepository);

    }

    @Override
    public Optional<User> find(User object) {
        Optional<User> byId = super.findById(object.getId());

        return byId;
    }

    @Override
    public Optional<User> findById(Long id) {
        return super.findById(id);
    }

    @Override
    public User save(User object) {
        super.save(object);
        return object;
    }

    @Override
    public Iterable<User> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {

        Optional<User> user  = super.findById(id);
        super.abstractRepository.delete(user.get());
    }

    @Override
    public void delete(User object) {
        super.abstractRepository.delete(object);

    }

}
