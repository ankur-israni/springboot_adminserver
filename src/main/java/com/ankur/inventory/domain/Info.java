package com.ankur.inventory.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Info {

    @Valid
    @NotNull(message="Manufacturing information cannot be empty")
    private String manufacturedBy;

    @Valid
    @NotNull(message="Item description is required")
    private String description;

    public Info(String manufacturedBy, String description){
        this.manufacturedBy=manufacturedBy;
        this.description=description;
    }

    public Info(){
    }

    public String getManufacturedBy() {
        return manufacturedBy;
    }

    public void setManufacturedBy(String manufacturedBy) {
        this.manufacturedBy = manufacturedBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
