package com.ankur.inventory.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class InventoryUpdateItemRequest {

    @Valid
    @NotNull(message="Item cannot be empty")
    private Item item;

    public InventoryUpdateItemRequest(Item item) {
        this.item = item;
    }

    public InventoryUpdateItemRequest(){
    }

    public Item getItem() {
        return item;
    }
}
