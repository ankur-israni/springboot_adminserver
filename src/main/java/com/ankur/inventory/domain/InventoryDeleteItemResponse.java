package com.ankur.inventory.domain;

public class InventoryDeleteItemResponse {

    private Status status;

    public InventoryDeleteItemResponse(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}
