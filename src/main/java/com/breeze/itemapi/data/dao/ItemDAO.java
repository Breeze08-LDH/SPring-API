package com.breeze.itemapi.data.dao;

import com.breeze.itemapi.data.entity.ItemEntity;

public interface ItemDAO {
    ItemEntity getItem(String itemId);
    ItemEntity saveItem(ItemEntity itemEntity);
}
