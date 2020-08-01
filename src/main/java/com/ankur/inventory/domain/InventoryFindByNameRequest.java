package com.ankur.inventory.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class InventoryFindByNameRequest {

    @Valid
    @NotNull(message="Item name cannot be empty")
    private String name;

    public InventoryFindByNameRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private InventoryFindByNameRequest(){

    }
}
