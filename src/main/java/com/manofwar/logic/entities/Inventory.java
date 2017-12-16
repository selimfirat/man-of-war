package com.manofwar.logic.entities;

import com.manofwar.logic.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Inventory class is a convenient name contains items with restricted access. That is just unmodifiable list of items.
 */
public class Inventory {

    private List<Item> items;

    /**
     * Simply, constructor
     */
    public Inventory() {
        this.items = new ArrayList<>();
    }

    /**
     * Returns the list of items
     * @return the list of items
     */
    public List<Item> getItems() {
        return items;
    }

}
