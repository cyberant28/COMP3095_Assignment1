package gbc.comp3095.recipeapp.models;

import javax.persistence.*;

@Entity
public class Item extends BaseEntity{

    @ManyToOne
    @JoinColumn(name="shipping_list_id", nullable=false)
    private ShoppingList shoppingList;


    @Column(name = "itemName")
    private String itemName;

    @Column(name = "price")
    private double itemPrice;

    public Item(String itemName, double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public Item() {

    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }
}
