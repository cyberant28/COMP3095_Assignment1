package gbc.comp3095.recipeapp.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ShoppingList extends BaseEntity {

    @Column(name = "title")
    private String title;


    @OneToMany()
    @JoinTable(name = "list_of_shopping_items", joinColumns = @JoinColumn( name = "shopping_list_id"),  inverseJoinColumns = @JoinColumn( name = "item_id"))
    private Set<Item> items = new HashSet<>();;

    @OneToOne()
    @JoinTable(name = "user_shopping_list", joinColumns = @JoinColumn(name = "shopping_list_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private User shoppingListAuthor;

    public ShoppingList(String title) {
        this.title = title;
    }

    public ShoppingList() {

    }

    public User getShoppingListAuthor() {
        return shoppingListAuthor;
    }

    public void setShoppingListAuthor(User shoppingListAuthor) {
        this.shoppingListAuthor = shoppingListAuthor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public void addItem(Item item){
        this.items.add(item);
    }
}
