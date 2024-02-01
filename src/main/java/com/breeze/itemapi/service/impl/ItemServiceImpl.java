package com.breeze.itemapi.service.impl;

import com.breeze.itemapi.data.dao.ItemDAO;
import com.breeze.itemapi.data.dto.ItemDTO;
import com.breeze.itemapi.data.entity.ItemEntity;
import com.breeze.itemapi.service.ItemService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    ItemDAO itemDAO;

    @Autowired
    public ItemServiceImpl(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    @Override
    public ItemDTO saveItem(String itemId, String itemName, int itemPrice, int itemStock) {

        ItemEntity itemEntity = new ItemEntity(itemId, itemName, itemPrice, itemStock);
        itemDAO.saveItem(itemEntity);
        ItemDTO itemDTO = new ItemDTO(
                itemEntity.getItemId(),
                itemEntity.getItemName(),
                itemEntity.getItemPrice(),
                itemEntity.getItemStock()
        );
        return itemDTO;
    }

    @Override
    public ItemDTO getItem(String itemId) {
        ItemEntity itemEntity = itemDAO.getItem(itemId);
        ItemDTO itemDTO = new ItemDTO(
                itemEntity.getItemId(),
                itemEntity.getItemName(),
                itemEntity.getItemPrice(),
                itemEntity.getItemStock()
        );
        return itemDTO;
    }
}
