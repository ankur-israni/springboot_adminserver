package com.ankur.inventory.domain;

import java.util.Collection;

public class InventoryFindByNameResponse {

    private Collection<Item> items;
    private Status status;

    public InventoryFindByNameResponse(Collection<Item> items, Status status) {
        this.items = items;
        this.status = status;
    }

    public InventoryFindByNameResponse() {

    }

    public Collection<Item> getItems() {
        return items;
    }

    public Status getStatus() {
        return status;
    }
}
