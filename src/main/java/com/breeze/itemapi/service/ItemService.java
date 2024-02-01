package com.breeze.itemapi.service;

import com.breeze.itemapi.data.dto.ItemDTO;

public interface ItemService {
    ItemDTO saveItem(String itemId, String itemName, int itemPrice, int itemStock);
    ItemDTO getItem(String itemId);
}
