package com.breeze.itemapi.data.entity;


import com.breeze.itemapi.data.dto.ItemDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "MST_ITEM")
public class ItemEntity extends BaseEntity{

    @Id
    String itemId;
    String itemName;
    Integer itemPrice;
    Integer itemStock;

    public ItemDTO toDTO(){
        return ItemDTO.builder()
                .itemId(itemId)
                .itemName(itemName)
                .itemPrice(itemPrice)
                .itemStock(itemStock)
                .build();
    }

}
