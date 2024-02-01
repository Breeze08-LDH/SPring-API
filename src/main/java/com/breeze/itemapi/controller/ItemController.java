package com.breeze.itemapi.controller;

import com.breeze.itemapi.data.dto.ItemDTO;
import com.breeze.itemapi.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/item-api")
public class ItemController {

    private final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // http://localhost:8080/api/item-api/item/{itemId}
    @GetMapping(value = "/item/{itemId}")
    public ItemDTO getItem(@PathVariable(name = "itemId") String itemId) {
        long startTime = System.currentTimeMillis();
        LOGGER.info(">>> [ItemController] perfotm [{}] of spring API", "getItem");

        ItemDTO itemDTO = itemService.getItem(itemId);

        LOGGER.info(">>> [getItem - Response] : itemtId = {}, itemName = {}, itemPrice = {}, itemStock = {}, Response Time = {}ms",
                        itemDTO.getItemId(),
                        itemDTO.getItemName(),
                        itemDTO.getItemPrice(),
                        itemDTO.getItemStock(),
                (System.currentTimeMillis() - startTime)
        );
        return itemDTO;
    }

    // http://localhost:8080/api/item-api/item
    @PostMapping(value = "/item")
    public ItemDTO createItem(@RequestBody ItemDTO itemDTO) {
        LOGGER.info(">>> [createItem] perform {} of Spring API.", "createItem");

        String itemId = itemDTO.getItemId();
        String itemName = itemDTO.getItemName();
        int itemPrice = itemDTO.getItemPrice();
        int itemStock = itemDTO.getItemStock();

        ItemDTO response = itemService.saveItem(itemId, itemName, itemPrice, itemStock);

        LOGGER.info(">>> [createItem] Response >> itemId : {}, itemName : {}, itemPrice : {}, itemStock : {}",
                response.getItemId(),
                response.getItemName(),
                response.getItemPrice(),
                response.getItemStock()
        );

        return response;
    }
}
