package com.storeinventory.inventory.controller;

public class StockOp {

    private Long productId;
    private Long quantity;
    private String type;

    public StockOp() {
    }

    public StockOp(Long productId, Long quantity, String type) {
        this.productId = productId;
        this.quantity = quantity;
        this.type = type;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
