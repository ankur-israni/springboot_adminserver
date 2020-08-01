package com.ankur.inventory.domain;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class Item {

    @Valid
    @NotNull(message="Item id cannot be empty")
    @Digits(integer=10,fraction=0)
    private Integer id;

    @Valid
    @NotNull(message="Item name cannot be empty")
    private String name;

    @Valid
    @NotNull(message="Item price cannot be empty")
    @Digits(integer=10,fraction=3)
    private Float price;

    @Valid
    @NotNull(message="Item info cannot be empty")
    private Info info;

    public Item(Integer id, String name, Float price, Info info) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.info=info;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
