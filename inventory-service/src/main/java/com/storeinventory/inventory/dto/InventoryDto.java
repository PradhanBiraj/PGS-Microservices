package com.storeinventory.inventory.dto;


import org.springframework.data.annotation.Id;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDto {
    @Id
    private String id;
    private Long productId;
    private Long quantity;
    private String type;
}


