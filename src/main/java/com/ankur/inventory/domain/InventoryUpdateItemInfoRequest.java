package com.ankur.inventory.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class InventoryUpdateItemInfoRequest {

    @Valid
    @NotNull(message="item id cannot be empty")
    private int itemId;

    @Valid
    @NotNull(message="Item Info is required")
    private Info info;

    public InventoryUpdateItemInfoRequest(int itemId, Info info){
        this.itemId=itemId;
        this.info=info;
    }

    public int getItemId() {
        return itemId;
    }

    public Info getInfo() {
        return info;
    }
}
