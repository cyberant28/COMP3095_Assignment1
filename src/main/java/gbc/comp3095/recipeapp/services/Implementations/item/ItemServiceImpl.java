package gbc.comp3095.recipeapp.services.Implementations.item;

import gbc.comp3095.recipeapp.models.Ingredient;
import gbc.comp3095.recipeapp.models.Item;
import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.Step;
import gbc.comp3095.recipeapp.repositories.ItemRepository;
import gbc.comp3095.recipeapp.services.Interfaces.item.ItemService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Optional<Item> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<Item> find(Item object) {
        return Optional.empty();
    }

    @Override
    public Item save(Item object) {
        return null;
    }

    @Override
    public Iterable<Item> findAll() {
        return null;
    }

    @Override
    public void delete(Item object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void updateItemNamePrice(Long id, String newName, double newPrice) {
        Item itemNew = itemRepository.findById(id).get();
        itemNew.setItemName(newName);
        itemNew.setItemPrice(newPrice);
        itemRepository.save(itemNew);
    }


}
