package com.breeze.itemapi.data.dao.Impl;

import com.breeze.itemapi.data.dao.ItemDAO;
import com.breeze.itemapi.data.entity.ItemEntity;
import com.breeze.itemapi.data.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemDAOImpl implements ItemDAO {
    ItemRepository itemRepository;

    @Autowired
    public ItemDAOImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ItemEntity getItem(String itemId) {
        ItemEntity itemEntity = itemRepository.getReferenceById(itemId);
        return itemEntity;
    }

    @Override
    public ItemEntity saveItem(ItemEntity itemEntity) {
        itemRepository.save(itemEntity);
        return itemEntity;
    }
}
