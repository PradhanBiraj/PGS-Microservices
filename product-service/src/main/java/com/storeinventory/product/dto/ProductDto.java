package com.storeinventory.product.dto;


import org.springframework.data.annotation.Id;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    @Id
    private String id;
    private String sku;
    private String name;
    private String uom;
}
