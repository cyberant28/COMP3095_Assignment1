package gbc.comp3095.recipeapp.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item extends BaseEntity{

    @Column(name = "name")
    private String itemName;

    @Column(name = "prize")
    private int itemPrize;


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrize() {
        return itemPrize;
    }

    public void setItemPrize(int itemPrize) {
        this.itemPrize = itemPrize;
    }
}
