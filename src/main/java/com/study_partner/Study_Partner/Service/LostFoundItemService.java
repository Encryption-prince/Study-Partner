package com.study_partner.Study_Partner.Service;

import com.study_partner.Study_Partner.Entity.LostFoundItem;
import com.study_partner.Study_Partner.Repository.LostFoundItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LostFoundItemService {

    private final LostFoundItemRepository lostFoundItemRepo;

    public LostFoundItem createItem(LostFoundItem item) {
        item.setCreatedAt(LocalDateTime.now());
        return lostFoundItemRepo.save(item);
    }

    public List<LostFoundItem> getAllItems() {
        return lostFoundItemRepo.findAll();
    }

    public Optional<LostFoundItem> getItemById(UUID id) {
        return lostFoundItemRepo.findById(id);
    }

    public LostFoundItem updateItemStatus(UUID id, String newStatus) {
        LostFoundItem item = lostFoundItemRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        item.setStatus(LostFoundItem.Status.valueOf(newStatus.toUpperCase()));
        item.setCreatedAt(LocalDateTime.now());
        return lostFoundItemRepo.save(item);
    }
}
