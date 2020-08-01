package com.ankur.inventory.domain;

public class InventoryUpdateItemInfoResponse {

    private Status status;

    public InventoryUpdateItemInfoResponse(Status status) {
        this.status = status;
    }

    public InventoryUpdateItemInfoResponse() {
    }

    public Status getStatus() {
        return status;
    }
}
