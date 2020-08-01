package com.ankur.inventory.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class InventoryDeleteItemRequest {

    @Valid
    @NotNull(message="Item id cannot be empty")
    private Integer itemId;


    public InventoryDeleteItemRequest(){
    }

    public InventoryDeleteItemRequest(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemId() {
        return itemId;
    }
}
