package com.storeinventory.inventory.controller;

import com.storeinventory.inventory.model.Inventory;
import com.storeinventory.inventory.repository.InventoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class InventoryController {

    private final InventoryRepository repo;

    public InventoryController(InventoryRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/inventory")
    public List<Inventory> list() {
        return repo.findAll();
    }

    @PostMapping("/inventory/stock-in")
    public ResponseEntity<Inventory> stockIn(@RequestBody StockOp op) {
        Inventory inv = repo.findByProductId(op.getProductId())
                .orElse(new Inventory(op.getProductId(), 0L));
        inv.setQuantity(inv.getQuantity() + op.getQuantity());
        inv.setType("receive");
        Inventory saved = repo.save(inv);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/inventory/adjust")
    public ResponseEntity<Inventory> adjust(@RequestBody StockOp op) {
        Inventory inv = repo.findByProductId(op.getProductId())
                .orElse(new Inventory(op.getProductId(), 0L));
        inv.setQuantity(inv.getQuantity() + op.getQuantity());
        inv.setType(op.getType());
        Inventory saved = repo.save(inv);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/inventory/dispatch")
    public ResponseEntity<?> dispatch(@RequestBody StockOp op) {
        Inventory inv = repo.findByProductId(op.getProductId())
                .orElse(new Inventory(op.getProductId(), 0L));
        if (inv.getQuantity() < op.getQuantity()) {
            return ResponseEntity.badRequest().body("Not enough stock");
        }
        inv.setQuantity(inv.getQuantity() - op.getQuantity());
        inv.setType("issue");
        Inventory saved = repo.save(inv);
        return ResponseEntity.ok(saved);
    }
}
