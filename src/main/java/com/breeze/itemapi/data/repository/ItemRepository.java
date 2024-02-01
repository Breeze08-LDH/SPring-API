package com.breeze.itemapi.data.repository;

import com.breeze.itemapi.data.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, String> {

}
