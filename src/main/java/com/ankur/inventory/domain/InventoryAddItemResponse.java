package com.ankur.inventory.domain;

public class InventoryAddItemResponse {

    private Status status;

    public InventoryAddItemResponse(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}
