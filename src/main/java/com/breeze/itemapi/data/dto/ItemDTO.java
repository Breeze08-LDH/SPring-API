package com.breeze.itemapi.data.dto;

import com.breeze.itemapi.data.entity.ItemEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ItemDTO {

    @NotNull
    private String itemId;

    @NotNull
    private String itemName;

    @NotNull
    @Min(100)
    @Max(1000000)
    private int itemPrice;

    @NotNull
    @Min(1)
    @Max(1000)
    private int itemStock;

    public ItemEntity toEntity(){
        return ItemEntity.builder()
                .itemId(itemId)
                .itemName(itemName)
                .itemPrice(itemPrice)
                .itemStock(itemStock)
                .build();
    }

}
