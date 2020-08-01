package com.ankur.inventory.service;

import com.ankur.inventory.domain.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InventoryService {

    private Map<Integer, Item> db = new HashMap<>();


    public InventoryService() {
        db.put(1, new Item(1, "Laptop", 99.67f, new Info("Apple", "16' macbook pro")));
        db.put(2, new Item(2, "Phone", 100.33f, new Info("Samsung", "Android phone")));
        db.put(3, new Item(3, "Brown Lamp", 65.99f, new Info("Costco", "Teak lamp - brown color")));
        db.put(4, new Item(4, "Alladin's Lamp", 67.99f, new Info("Genie", "Magic lamp with 3 wishes")));
    }


/*    public ResponseEntity<?> listAll() {
        return new ResponseEntity<InventoryListAllResponse>(new InventoryListAllResponse(db.values()), HttpStatus.OK);
    }*/

    public ResponseEntity<?> listAll() {
        HttpHeaders responseHeader = new HttpHeaders();




        responseHeader.set("author", "onlyankur@gmail.com");
        responseHeader.set("Access-Control-Expose-Headers", "*");

        return new ResponseEntity<InventoryListAllResponse>(new InventoryListAllResponse(db.values()), responseHeader, HttpStatus.OK);
    }

    public ResponseEntity<?> filterById(int id) {
        Item item = db.get(id);
        if (item != null) {
            return new ResponseEntity<InventoryFindByIdResponse>(new InventoryFindByIdResponse(item),
                    HttpStatus.OK);
        }
        Item itemNotFound = new Item(-1, "Not Found", -1f, null);
        return new ResponseEntity<InventoryFindByIdResponse>(new InventoryFindByIdResponse(itemNotFound),
                HttpStatus.OK);
    }

    public ResponseEntity<?> findById(InventoryFindByIdRequest request) {
        Integer id = request.getItemId();
        Item item = db.get(id);
        if (item != null) {
            return new ResponseEntity<InventoryFindByIdResponse>(new InventoryFindByIdResponse(item),
                    HttpStatus.OK);
        }
        Item itemNotFound = new Item(-1, "Not Found", -1f, null);
        return new ResponseEntity<InventoryFindByIdResponse>(new InventoryFindByIdResponse(itemNotFound),
                HttpStatus.OK);
    }


    public ResponseEntity<?> add(InventoryAddItemRequest request) {
        InventoryAddItemResponse response = null;
        Item item = request.getItem();
        if (item != null && item.getId() != null) {
            if (db.containsKey(item.getId())) {
                response = new InventoryAddItemResponse(Status.CANNOT_ADD_ITEM_ALREADY_EXISTS);
            } else {
                db.put(request.getItem().getId(), request.getItem());
                response = new InventoryAddItemResponse(Status.SUCCESS);
            }
        }
        return new ResponseEntity<InventoryAddItemResponse>(response, HttpStatus.OK);
    }

    public ResponseEntity<?> update(InventoryUpdateItemRequest request) {
        InventoryUpdateItemResponse response = null;

        Item item = request.getItem();
        if (item != null && item.getId() != null && db.containsKey(item.getId())) {
            db.put(item.getId(), item);
            response = new InventoryUpdateItemResponse(Status.SUCCESS);
        } else {
            response = new InventoryUpdateItemResponse(Status.CANNOT_UPDATE_ITEM_DOES_NOT_EXIST);
        }

        return new ResponseEntity<InventoryUpdateItemResponse>(response, HttpStatus.OK);
    }


    public ResponseEntity<?> updateItemInfo(InventoryUpdateItemInfoRequest request) {
        InventoryUpdateItemInfoResponse response = null;

        Info info = request.getInfo();
        int itemId = request.getItemId();
        Item itemToUpdate = db.get(itemId);
        if (info != null && info.getDescription() != null && info.getManufacturedBy() != null && itemToUpdate!=null) {
            itemToUpdate.setInfo(info);
            response = new InventoryUpdateItemInfoResponse(Status.SUCCESS);
        }else {
            response = new InventoryUpdateItemInfoResponse(Status.CANNOT_UPDATE_ITEM_INFO);
        }

        return new ResponseEntity<InventoryUpdateItemInfoResponse>(response, HttpStatus.OK);
    }

    public ResponseEntity<?> remove(Integer itemId) {

        InventoryDeleteItemResponse response = null;

//        Integer itemId = request.getItemId();
        if (itemId != null && db.containsKey(itemId)) {
            db.remove(itemId);
            response = new InventoryDeleteItemResponse(Status.SUCCESS);
        } else {
            response = new InventoryDeleteItemResponse(Status.CANNOT_REMOVE_ITEM_DOES_NOT_EXIST);
        }

        return new ResponseEntity<InventoryDeleteItemResponse>(response, HttpStatus.OK);
    }

    public ResponseEntity<?> findByName(InventoryFindByNameRequest request) {
        List<Item> result = new ArrayList<>();
        Status status = Status.NO_NAME_MATCH;
        String name = StringUtils.trimToNull(request.getName());
        if (name != null) {
            for (Item item : db.values()) {
                if (StringUtils.containsIgnoreCase(item.getName(), name)) {
                    result.add(item);
                    status = Status.SUCCESS;
                }
            }
        }
        InventoryFindByNameResponse response = new InventoryFindByNameResponse(result, status);
        return new ResponseEntity<InventoryFindByNameResponse>(response, HttpStatus.OK);
    }
}
