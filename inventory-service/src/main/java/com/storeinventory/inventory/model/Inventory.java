package com.storeinventory.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "inventory")
public class Inventory {

    @Id
    private String id;

    private Long productId;
    private Long quantity;
    private String type;

    // Constructor you use in controller: new Inventory(productId, 0L)
    public Inventory(Long productId, Long quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
    
    public Inventory(Long productId, Long quantity, String type) {
        this.productId = productId;
        this.quantity = quantity;
        this.type = type;
    }

    // Explicit getters/setters so it works even if Lombok is not processed
    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
