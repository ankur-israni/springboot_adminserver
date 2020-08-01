package com.ankur.inventory.domain;


import java.util.Collection;

public class InventoryListAllResponse {


    private Collection<Item> items;

    public InventoryListAllResponse(Collection<Item> items) {
        this.items = items;
    }

    public Collection<Item> getItems() {
        return items;
    }


}
