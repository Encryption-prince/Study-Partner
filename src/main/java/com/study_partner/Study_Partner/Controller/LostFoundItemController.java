package com.study_partner.Study_Partner.Controller;

import com.study_partner.Study_Partner.Entity.LostFoundItem;
import com.study_partner.Study_Partner.Service.LostFoundItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/lost-found")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class LostFoundItemController {

    private final LostFoundItemService lostFoundItemService;

    // Create a lost or found item report
    @PostMapping
    public ResponseEntity<?> createItem(@RequestBody LostFoundItem item) {
        LostFoundItem savedItem = lostFoundItemService.createItem(item);
        return ResponseEntity.ok(Map.of(
                "message", "Item reported successfully",
                "id", savedItem.getId()
        ));
    }

    // Get all lost & found items
    @GetMapping
    public ResponseEntity<?> getAllItems() {
        return ResponseEntity.ok(lostFoundItemService.getAllItems());
    }

    // Get single item details by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getItemById(@PathVariable UUID id) {
        Optional<LostFoundItem> item = lostFoundItemService.getItemById(id);
        if (item.isPresent()) {
            return ResponseEntity.ok(item.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Item not found"));
        }
    }

    // Update item status (CLAIMED/LOST/FOUND)
    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable UUID id, @RequestParam String newStatus) {
        try {
            LostFoundItem updatedItem = lostFoundItemService.updateItemStatus(id, newStatus);
            return ResponseEntity.ok(Map.of("message", "Item status updated successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        }
    }
}

