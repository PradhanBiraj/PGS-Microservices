package com.storeinventory.inventory.repository;

import com.storeinventory.inventory.model.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface InventoryRepository extends MongoRepository<Inventory, String> {
    Optional<Inventory> findByProductId(Long productId);
}
