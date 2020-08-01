package com.ankur.inventory.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class InventoryFindByIdRequest {

    /**
     * Need this for serialization and de-serialization
     */
    public InventoryFindByIdRequest(){
    }

    @Valid
    @NotNull(message="Item id cannot be empty")
    private Integer itemId;

    public InventoryFindByIdRequest(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemId() {
        return itemId;
    }


}
