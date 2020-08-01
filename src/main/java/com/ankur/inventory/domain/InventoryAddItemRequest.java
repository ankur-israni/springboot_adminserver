package com.ankur.inventory.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class InventoryAddItemRequest {

    @Valid
    @NotNull(message="Item cannot be empty")
    private Item item;

    public InventoryAddItemRequest(){
    }

    public InventoryAddItemRequest(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
}
